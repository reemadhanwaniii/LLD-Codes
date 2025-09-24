package services;

import DTOs.GetAtmAmountDTO;
import apis.BackendAPI;
import apis.NodeBackendAPI;
import models.ATM;

public class CashDispenseServiceImpl implements CashDispenserService{

    private final BackendAPI backendAPI;

    public CashDispenseServiceImpl() {
        this.backendAPI = new NodeBackendAPI();
    }
    @Override
    public void dispenseCash(ATM atm, int amount) {
        int atmAmount = this.backendAPI.getAmount(new GetAtmAmountDTO(atm.getAtmId()));
        if(amount > atmAmount){
            throw new RuntimeException("ATM doesn't have enough cash to dispense");
        }
        System.out.println("Dispensing cash " + amount);
    }
}
