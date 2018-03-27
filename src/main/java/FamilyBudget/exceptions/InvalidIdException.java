package FamilyBudget.exceptions;

public class InvalidIdException extends Exception {
    private static final long serialVersionUID = -69637829093235855L;

    public InvalidIdException(String message) {
        super(message);
    }
}
