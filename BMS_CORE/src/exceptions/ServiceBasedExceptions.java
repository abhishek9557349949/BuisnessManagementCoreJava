package exceptions;

public class ServiceBasedExceptions extends Exception{
	
	private static final long serialVersionUID = -3372664571043193359L;

	public ServiceBasedExceptions() {
        super();
    }

    public ServiceBasedExceptions(String message) {
        super(message);
    }

    public ServiceBasedExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceBasedExceptions(Throwable cause) {
        super(cause);
    }

}
