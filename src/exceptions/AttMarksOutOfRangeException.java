package exceptions;

public class AttMarksOutOfRangeException extends Exception{

	private static final long serialVersionUID = 1L;

	public AttMarksOutOfRangeException(String message) {
        super(message);
    }
}
