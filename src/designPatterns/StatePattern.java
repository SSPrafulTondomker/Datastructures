package designPatterns;


class ATM {
    ATMState atmState;
    ATM() {
    }

    void init() {
        this.atmState = new ReadyState(this);
    }
    void changeState(ATMState atmState) {
        this.atmState = atmState;
    }

    public void displayStartMessage() {
        this.atmState.displayStartMessage();
    }
    public void insertCard() {
        this.atmState.insertCard();
    }

    public void ejectCard() {
        this.atmState.ejectCard();
    }

    public void insertPin(String pin) {
        this.atmState.insertPin(pin);
    }

    public void requestCash() {
        this.atmState.requestCash();
    }

}
abstract class ATMState {
    ATMState() {
    }

    abstract void displayStartMessage();
    abstract void insertCard();

    abstract void ejectCard();

    abstract void insertPin(String pin);

    abstract void requestCash();
}

class ReadyState extends  ATMState {

    ATM atm;
    ReadyState(ATM atm) {
        this.atm = atm;
    }

    void displayStartMessage() {
        System.out.println("ATM is ready for use !!!");
        this.atm.changeState(new HasCardState(this.atm));
    }
    @Override
    void insertCard() {
        System.out.println("Not allowed !!!");
    }

    @Override
    void ejectCard() {
        this.atm.changeState(new ReadyState(this.atm));
        System.out.println("Eject successful !!!");
    }

    @Override
    void insertPin(String pin) {
        System.out.println("Not allowed !!!");
    }

    @Override
    void requestCash() {
        System.out.println("Not allowed !!!");
    }
}

class HasCardState extends ATMState {
    ATM atm;
    HasCardState(ATM atm) {
        this.atm = atm;
    }

    void displayStartMessage() {
        System.out.println("ATM is ready for use !!!");
    }
    @Override
    void insertCard() {
        System.out.println("Please insert the card !!!");
        this.atm.changeState(new HasPinState(this.atm));
    }

    @Override
    void ejectCard() {
        System.out.println("Not allowed !!!");

    }

    @Override
    void insertPin(String pin) {
        System.out.println("Not allowed !!!");

    }

    @Override
    void requestCash() {
        System.out.println("Not allowed !!!");

    }
}


class HasPinState extends ATMState {

    ATM atm;
    HasPinState(ATM atm) {
        this.atm = atm;
    }

    @Override
    void displayStartMessage() {
        System.out.println("Not allowed !!!");

    }

    @Override
    void insertCard() {
        System.out.println("Not allowed !!!");

    }

    @Override
    void ejectCard() {
        this.atm.changeState(new ReadyState(this.atm));
        System.out.println("Eject successful !!!");
    }

    @Override
    void insertPin(String pin) {
        System.out.println("Pin is validate select the option 1. deposite and 2. withdrawl");
        this.atm.changeState(new CashState(this.atm));
    }

    @Override
    void requestCash() {
        System.out.println("Not allowed !!!");

    }
}

class CashState extends ATMState{
    ATM atm;
    CashState(ATM atm) {
        this.atm = atm;
    }

    @Override
    void displayStartMessage() {
        System.out.println("Not allowed !!!");

    }

    @Override
    void insertCard() {
        System.out.println("Not allowed !!!");

    }

    @Override
    void ejectCard() {
        this.atm.changeState(new ReadyState(this.atm));
        System.out.println("Eject successful !!!");
    }

    @Override
    void insertPin(String pin) {
        System.out.println("Not allowed !!!");

    }

    @Override
    void requestCash() {
        System.out.println("Money withdrawl request is successful !!!");
    }
}

public class StatePattern {
    public static void main(String[] args){
            ATM atm = new ATM();

            atm.init();
            atm.displayStartMessage();
            atm.insertCard();
            atm.ejectCard();
            atm.displayStartMessage();
            atm.insertCard();
            atm.insertPin("123");
            atm.requestCash();
            atm.insertCard();

    }
}
