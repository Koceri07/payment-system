package springboot.paymentsystem.paymentsystem.service;

import springboot.paymentsystem.paymentsystem.dao.entity.CardEntity;
import springboot.paymentsystem.paymentsystem.dao.repository.CardRepository;
import springboot.paymentsystem.paymentsystem.exception.NotFoundException;
import springboot.paymentsystem.paymentsystem.mapper.CardMapper;
import springboot.paymentsystem.paymentsystem.model.request.CreateCardRequest;
import springboot.paymentsystem.paymentsystem.model.request.CreateDepositRequest;
import springboot.paymentsystem.paymentsystem.model.response.CardResponse;
import springboot.paymentsystem.paymentsystem.util.CardUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static springboot.paymentsystem.paymentsystem.model.enums.ErrorMessage.CARD_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class CardService {
    private final CardRepository cardRepository;
    private final CardUtil cardUtil;
    private final CardMapper cardMapper;

    public void createCard(CreateCardRequest createCardRequest) {
        log.info("Action.createCard.start holder name: {}", createCardRequest.getHolderName());
        var generatedCardNumber = cardUtil.generate("409858", 16);
        var entity = cardMapper.toEntity(createCardRequest);
        entity.setCardNumber(generatedCardNumber);
        cardRepository.save(entity);
        log.info("Action.createCard.end holder name: {}", createCardRequest.getHolderName());
    }

    public CardResponse getCardByNumber(String cardNumber) {
        log.info("Action.getCardByNumber.start");
        var cardEntity = cardRepository.findByCardNumber(cardNumber)
                .orElseThrow(() -> new NotFoundException(CARD_NOT_FOUND.getFormattedMessage(cardNumber)));
        var response = cardMapper.toResponse(cardEntity);
        log.info("Action.getCardByNumber.end holder name: {}", cardEntity.getHolderName());
        return response;
    }

    public void deposit(CreateDepositRequest createDepositRequest){
        log.info("Action.deposit.start");
        var cartEntity = cardRepository.findByCardNumber(createDepositRequest.getCartNumber())
                .orElseThrow(() -> new NotFoundException(CARD_NOT_FOUND.getFormattedMessage(createDepositRequest)));
        cartEntity.setBalance(createDepositRequest.getAmount());
        cardRepository.save(cartEntity);
        log.info("Action.deposit.end");
    }
}
