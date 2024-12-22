package database;
import utils.*;
import wsp.*;

import java.io.Serializable;

import enums.*;


/**
 * The Log class represents a log entry in the system.
 * Each log entry has an associated action description.
 *
 */
public class Log implements Serializable {

    private String action;
    
    public Log( String action){
        this.action = action;
    }
    
    public String toString() {
    	return action;
    }

}
