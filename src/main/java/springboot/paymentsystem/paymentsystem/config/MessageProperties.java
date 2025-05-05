package springboot.paymentsystem.paymentsystem.config;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:message.properties", encoding = "UTF-8")
@Data
public class MessageProperties {
    private String holderNameNotValid;
    private String expirationYearsNotValid;
    private String cardTypeNotValid;
}
