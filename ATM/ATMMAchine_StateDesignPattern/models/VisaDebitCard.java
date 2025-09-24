package models;

import enums.CardNetworkType;
import enums.CardType;

public class VisaDebitCard extends Card implements Debit,Visa{
    public VisaDebitCard(long cardNumber, int pin, CardType cardType, String bankName, CardNetworkType name) {
        super(cardNumber, pin, cardType, bankName, name);
    }

    @Override
    public void makePinPayment() {
        this.connectToVisaCard();
        System.out.println("Making Payment with Pin");
    }

    @Override
    public void connectToVisaCard() {
        System.out.println("Connected to VisaDebitCard");
    }
}
