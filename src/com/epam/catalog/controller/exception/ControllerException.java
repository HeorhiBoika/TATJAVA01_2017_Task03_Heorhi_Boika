package com.epam.catalog.controller.exception;

/**
 * Created by PC on 31.01.2017.
 */
public class ControllerException extends Exception {
    public ControllerException() {
        super();
    }

    public ControllerException(String message) {
        super(message);
    }

    public ControllerException(Exception e) {
        super(e);
    }

    public ControllerException(String message, Exception e) {
        super(message, e);
    }
}
