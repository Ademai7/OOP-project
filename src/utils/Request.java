package utils;

import enums.*;
import wsp.*;

import java.io.Serializable;
import java.util.*;

/**
 * The Request class represents a request (it also can be complaint) made by an employee to the dean.
 */
public class Request implements Serializable {

    private Emergency emergency;
    private String message;
    private Dean to;
    private Status status;


    public Request(Emergency emergency, String message, Dean to) {
        this.emergency = emergency;
        this.message = message;
        this.to = to;
        this.status = Status.NEW;
        to.addRequest(this);
    }

    public Emergency getEmergency() {
        return emergency;
    }

    public String getMessage() {
        return message;
    }

    /**
     * Gets the dean to whom the request is directed.
     *
     * @return The dean.
     */
    public Dean getTo() {
        return to;
    }


    public void setEmergency(Emergency emergency) {
        this.emergency = emergency;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    
    public void setStatus(Status status) {
    	this.status = status;
    }

    /**
     * Sets the dean to whom the request is directed.
     *
     * @param to The dean.
     */
    public void setTo(Dean to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Request [emergency=" + emergency + ", status=" + status + ", message=" + message + ", to=" + to + "]";
    }


}
