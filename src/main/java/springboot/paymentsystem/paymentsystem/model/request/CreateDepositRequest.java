package springboot.paymentsystem.paymentsystem.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateDepositRequest {
    private String cartNumber;
    private BigDecimal amount;
}
