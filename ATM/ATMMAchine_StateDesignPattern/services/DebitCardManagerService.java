package services;

import models.Card;

public class DebitCardManagerService implements CardManagerServices{
    @Override
    public boolean validateCard(Card card, String pin) {
//        make an api call to verify card Details
        return true;
    }

    @Override
    public boolean validateWithdrawal(Card card,int transactionId, double amount) {
        return false;
    }



    @Override
    public boolean doTransaction(Card card, double amount, int transactionId) {
        return true;
    }
}
