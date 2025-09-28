package states;

import DTOs.CreateTransactionDTO;
import apis.BackendAPI;
import apis.NodeBackendAPI;
import enums.ATMState;
import models.Card;
import models.ATM;

public class ReadyForTransactionState implements State{

    private final ATM atm;
    private final BackendAPI backendAPI;

    public ReadyForTransactionState(ATM atm) {
        this.atm = atm;
        this.backendAPI = new NodeBackendAPI();
    }

    @Override
    public int initTransaction() {
        CreateTransactionDTO createTransactionDTO = new CreateTransactionDTO(this.atm.getAtmId());
        int transactionId = this.backendAPI.createTransaction(createTransactionDTO);

        if(transactionId == 0){
            throw new RuntimeException("Failed to create transaction");
        }

//        Now we have the transactionId from the backend we can now move to Read card state;
        this.atm.setAtmState(new ReadCardDetailsAndPinState(this.atm));
        return transactionId;
    }

    @Override
    public void ejectCard() {
        throw  new IllegalStateException("Cannot eject card");
    }

    @Override
    public int dispenseCash(Card card, int amount, int transactionId) {
        throw new IllegalStateException("Cannot dispense cash");
    }

    @Override
    public boolean readCardAndPin(Card card,String pin) {
        throw new IllegalStateException("Can't read card");
    }

    @Override
    public boolean withdrawCash(Card card,int transactionId, int amount) {
        throw new IllegalStateException("Cann't withdraw cash");
    }

    @Override
    public boolean cancelTransaction(int transactionId) {
        throw new IllegalStateException("Cannot cancel transaction");
    }

    @Override
    public ATMState getATMState() {
        return ATMState.READY_FOR_TRANSACTION;
    }
}
