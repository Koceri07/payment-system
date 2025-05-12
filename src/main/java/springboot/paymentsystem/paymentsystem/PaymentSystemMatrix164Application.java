package springboot.paymentsystem.paymentsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
@ImportAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class PaymentSystemMatrix164Application {

    public static void main(String[] args) {
        SpringApplication.run(PaymentSystemMatrix164Application.class, args);
    }

}
