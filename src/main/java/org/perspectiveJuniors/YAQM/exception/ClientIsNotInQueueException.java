package org.perspectiveJuniors.YAQM.exception;

/**
 * Created by eljetto on 4/20/15.
 */
public class ClientIsNotInQueueException extends Throwable {
    public ClientIsNotInQueueException() {}

    public ClientIsNotInQueueException(String message)
    {
        super(message);
    }
}
