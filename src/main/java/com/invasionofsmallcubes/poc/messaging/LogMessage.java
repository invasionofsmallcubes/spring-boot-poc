package com.invasionofsmallcubes.poc.messaging;

import java.io.Serializable;

public class LogMessage implements Serializable {

    private String message;

    public LogMessage() {
    }

    public LogMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
