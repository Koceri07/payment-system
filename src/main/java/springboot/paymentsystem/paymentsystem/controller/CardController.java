package springboot.paymentsystem.paymentsystem.controller;

import org.springframework.web.bind.annotation.*;
import springboot.paymentsystem.paymentsystem.model.request.CreateCardRequest;
import springboot.paymentsystem.paymentsystem.model.request.CreateDepositRequest;
import springboot.paymentsystem.paymentsystem.model.response.CardResponse;
import springboot.paymentsystem.paymentsystem.service.CardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @PatchMapping
    public void deposit(@RequestBody CreateDepositRequest createDepositRequest){
        cardService.deposit(createDepositRequest);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCard(@RequestHeader(name = "Accept-Language", defaultValue = "en") String language,
                           @RequestBody @Valid CreateCardRequest createCardRequest) {
        cardService.createCard(createCardRequest);
    }

    @GetMapping("/{cardNumber}")
    public CardResponse getCardByNumber(@PathVariable String cardNumber) {
        return cardService.getCardByNumber(cardNumber);
    }

}
