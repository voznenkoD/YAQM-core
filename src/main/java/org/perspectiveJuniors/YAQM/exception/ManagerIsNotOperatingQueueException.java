package org.perspectiveJuniors.YAQM.exception;

/**
 * Created by eljetto on 4/20/15.
 */
public class ManagerIsNotOperatingQueueException extends Throwable {
    public ManagerIsNotOperatingQueueException() {}

    public ManagerIsNotOperatingQueueException(String message)
    {
        super(message);
    }
}
