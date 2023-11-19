package exceptions;

public class DatabaseExceptions extends Exception{
	
	private static final long serialVersionUID = 1709757237496434215L;
	
	public DatabaseExceptions() {
        super();
    }

    public DatabaseExceptions(String message) {
        super(message);
    }

    public DatabaseExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public DatabaseExceptions(Throwable cause) {
        super(cause);
    }
}
