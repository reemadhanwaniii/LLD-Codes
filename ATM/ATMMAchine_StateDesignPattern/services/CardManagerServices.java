package services;

import models.Card;

public interface CardManagerServices {
    boolean validateCard(Card card,String pin);
    boolean validateWithdrawal(Card card,int transactionId,double amount);

    boolean doTransaction(Card card,double amount,int transactionId);
}

