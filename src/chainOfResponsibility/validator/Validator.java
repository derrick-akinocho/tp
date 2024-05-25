package chainOfResponsibility;

public abstract class Validator {

    protected Validator nextValidator;

    public void setNext(Validator v) {
        this.nextValidator = v;
    }

    public abstract boolean check(String data);
}
