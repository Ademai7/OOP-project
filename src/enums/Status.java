package enums;

import java.io.Serializable;

/**
 * The Status enum represents different statuses in a system for orders and requests.
 * It includes four statuses: NEW, VIEWED, ACCEPTED, and REJECTED.
 */
public enum Status implements Serializable {
	NEW, VIEWED, ACCEPTED, REJECTED;
}
