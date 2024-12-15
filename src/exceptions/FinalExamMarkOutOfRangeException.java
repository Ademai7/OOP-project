package exceptions;

public class FinalExamMarkOutOfRangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public FinalExamMarkOutOfRangeException(String message) {
        super(message);
    }
}