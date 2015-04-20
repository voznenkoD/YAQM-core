package org.perspectiveJuniors.YAQM.exception;

/**
 * Created by eljetto on 4/20/15.
 */
public class NotRegisteredUserException extends Throwable {
    public NotRegisteredUserException() {}

    public NotRegisteredUserException(String message)
    {
        super(message);
    }
}
