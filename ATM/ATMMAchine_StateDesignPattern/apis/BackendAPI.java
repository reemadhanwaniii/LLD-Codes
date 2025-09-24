package apis;

import DTOs.CreateTransactionDTO;
import DTOs.GetAtmAmountDTO;
import DTOs.UpdateStateDTO;
import states.DispensingCashState;

public interface BackendAPI {
    int createTransaction(CreateTransactionDTO atmId);

    boolean updateState(UpdateStateDTO updateStateDTO);

    int getAmount(GetAtmAmountDTO atmId);
}
