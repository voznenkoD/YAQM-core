package org.perspectiveJuniors.YAQM.exception;

/**
 * Created by eljetto on 4/20/15.
 */
public class ClientAlreadyInQueueException extends Throwable {
    public ClientAlreadyInQueueException() {}

    public ClientAlreadyInQueueException(String message)
    {
        super(message);
    }
}
