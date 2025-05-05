package springboot.paymentsystem.paymentsystem.model.request;

import springboot.paymentsystem.paymentsystem.model.enums.CardType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCardRequest {

    @NotBlank(message = "{holder-name.message}")
    private String holderName;

    @NotNull(message = "{expiration-years.message}")
    private Integer expirationYears;

    @NotNull(message = "{card-type.message")
    private CardType type;
}
