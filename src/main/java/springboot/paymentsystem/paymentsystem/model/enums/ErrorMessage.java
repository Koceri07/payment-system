package springboot.paymentsystem.paymentsystem.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    CARD_NOT_FOUND("Card not found with number %s"),
    CARD_NOT_ACTIVE("%s card is not active"),
    CARD_NOT_ENOUGH_BALANCE("%s card has not enough balance");

    private final String value;

    public String getFormattedMessage(Object... args) {
        return String.format(value, args);
    }
}
