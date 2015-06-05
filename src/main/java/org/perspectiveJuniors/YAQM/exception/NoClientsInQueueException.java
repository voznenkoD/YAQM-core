package org.perspectiveJuniors.YAQM.exception;

/**
 * Created by vsevolod on 05.06.15.
 */
public class NoClientsInQueueException extends Throwable{
    public NoClientsInQueueException() {}

    public NoClientsInQueueException(String message)
    {

        super(message);
    }
}
