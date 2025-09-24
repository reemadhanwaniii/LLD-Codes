package models;

import enums.CardNetworkType;
import enums.CardType;

public class Card {

    private final long cardNumber;
    private final int pin;
    private final CardType cardType;
    private final String bankName;
    private final CardNetworkType name;

    public Card(long cardNumber, int pin, CardType cardType, String bankName, CardNetworkType name) {
        this.cardNumber = cardNumber;
        this.pin = pin;
        this.cardType = cardType;
        this.bankName = bankName;
        this.name = name;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    public String getBankName() {
        return bankName;
    }

    public CardType getCardType() {
        return cardType;
    }

    public CardNetworkType getName() {
        return name;
    }
}
