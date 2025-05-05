package springboot.paymentsystem.paymentsystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateTransferRequest {
    private String senderCardNumber;
    private String receiverCardNumber;
    private BigDecimal amount;
}
