package springboot.paymentsystem.paymentsystem.model.response;

import springboot.paymentsystem.paymentsystem.model.enums.CardType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponse {
    private String holderName;
    private String cardNumber;
    private LocalDate expirationDate;
    private String cvv;
    private CardType type;
    private BigDecimal balance;
}
