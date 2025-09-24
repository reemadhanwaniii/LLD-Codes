package models;

import DTOs.UpdateStateDTO;
import apis.BackendAPI;
import apis.NodeBackendAPI;
import enums.ATMState;
import states.ReadyForTransactionState;
import states.State;

public class ATM {
    private final String atmId;
    private State atmState;
    private final BackendAPI nodeApi;

    public ATM(String atmId) {
        this.atmId = atmId;
        this.nodeApi = new NodeBackendAPI();
        this.atmState = new ReadyForTransactionState(this,this.nodeApi);
    }

    public String getAtmId() {
        return atmId;
    }

    public State getAtmState() {
        return atmState;
    }

    public void setAtmState(State atmState) {
        this.atmState = atmState;
        this.nodeApi.updateState(new UpdateStateDTO(this.atmId,atmState.getATMState()));
    }
}
