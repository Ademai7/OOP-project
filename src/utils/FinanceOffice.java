package utils;

import wsp.*;

import java.io.Serializable;

import database.Database;
import enums.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Manages student finances and the associated finance managers.
 */
public class FinanceOffice implements Serializable {

    /**
     * Stores student balances.
     */
    private HashMap<Student, Double> studentBalances;

    /**
     * List of finance managers.
     */
    private Vector<FinanceManager> financeManagers;

    /**
     * Initializes the finance office with empty balances and finance managers.
     */
    public FinanceOffice() {
        this.studentBalances = new HashMap<>();
        this.setFinanceManagers(new Vector<>());
    }

    /**
     * Adds funds to a student's account.
     * @param student The student to add funds to.
     * @param amount Amount to add.
     */
    public void addFunds(Student student, double amount) {
        studentBalances.put(student, studentBalances.getOrDefault(student, 0.0) + amount);
    }

    /**
     * Gets a student's balance.
     * @param student The student whose balance to retrieve.
     * @return The student's balance.
     */
    public double getBalance(Student student) {
        return studentBalances.getOrDefault(student, 0.0);
    }

    /**
     * Gets the list of finance managers.
     * @return List of finance managers.
     */
    public Vector<FinanceManager> getFinanceManagers() {
        return financeManagers;
    }

    /**
     * Sets the list of finance managers.
     * @param financeManagers List of finance managers.
     */
    public void setFinanceManagers(Vector<FinanceManager> financeManagers) {
        this.financeManagers = financeManagers;
    }
}