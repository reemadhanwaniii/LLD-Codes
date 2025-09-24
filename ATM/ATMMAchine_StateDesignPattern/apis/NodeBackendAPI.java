package apis;

import DTOs.CreateTransactionDTO;
import DTOs.GetAtmAmountDTO;
import DTOs.UpdateStateDTO;

public class NodeBackendAPI implements BackendAPI {


//    should be only responsible for connecting with backend and returning response

    @Override
    public int createTransaction(CreateTransactionDTO createTransactionDTO) {
        if(createTransactionDTO.getAtmId() == null || createTransactionDTO.getAtmId().isEmpty()){
            throw new IllegalArgumentException("atmId can't be null or empty");
        }
        int txnId = (int)(Math.random()*100000);
        return txnId;
    }

    @Override
    public boolean updateState(UpdateStateDTO updateStateDTO) {
//        Assume there is a implementation that calls backend to update state
        return true; //mimic response
    }

    @Override
    public int getAmount(GetAtmAmountDTO atmId) {
        return 10000;
    }
}

