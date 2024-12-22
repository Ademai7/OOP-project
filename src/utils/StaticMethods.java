package utils;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import database.Database;
import database.Log;
import wsp.User;


/**
 * The StaticMethods class contains static utility methods used throughout the application.
 */
public class StaticMethods {

	/**
     * Prints the elements of a list with their corresponding indices.
     *
     * @param list The list to be printed.
     */
	public static void printList(List list) {
		for(int i = 0; i<list.size(); i++) {
			System.out.println(i+1+ ") " + list.get(i));
		}
	}
	
	/**
     * Validates and returns user input within the range [0, n].
     *
     * @param n The upper bound of the range.
     * @return The validated user input.
     */
	public static int validate(int n) {
		Scanner s = new Scanner(System.in);
		int choice;
		while(true) {
			try {
				choice = s.nextInt();
				if (0 <= choice && choice <= n) {
					break;
				}
				else {
					System.out.println("Please enter number from 0 to " + n);
				}
				
			}
			catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                s.nextLine();
            }

		}
		return choice;
	}
	
	/**
     * Validates and returns user input within the range [a, n].
     *
     * @param a The lower bound of the range.
     * @param n The upper bound of the range.
     * @return The validated user input.
     */
	public static int validate(int a, int n) {
		Scanner s = new Scanner(System.in);
		int choice;
		while(true) {
			try {
				choice = s.nextInt();
				if (a <= choice && choice <= n) {
					break;
				}
				else {
					System.out.println("Please enter number from " + a + " to " + n);
				}
				
			}
			catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                s.nextLine();
            }

		}
		return choice;
	}
	
	/**
     * Gets valid user input based on a regular expression.
     *
     * @param prompt The prompt to be displayed to the user.
     * @param regex  The regular expression for validation.
     * @return The validated user input.
     */
	public static String getValidInput(String promt, String regex) {
		Scanner in = new Scanner(System.in);
		System.out.println(promt);
		
		while(!in.hasNext(regex)) {
			System.out.print("Invalid input. Please enter a valid name (only letters:");
			in.next();
		}
		
		return in.next();
	}
	
	
	/**
     * Subscribes the user to a research journal.
     *
     * @param u The user to be subscribed.
     */
	public static void subscribeJournal(User u) {
		Vector<ResearchJournal> journals = (Vector<ResearchJournal>)Database.getInstance().getJournals().clone();
		journals.removeAll(u.getJournals());
		if(journals.isEmpty()) {
			System.out.println("No journals");
			return;
		}
		
		System.out.println("Enter 0 to return back");
		System.out.println("Choose journal:");
		
		
		
		printList(journals);
		
		int choice = validate(journals.size());
		
		if(choice == 0) {
			return;
		}
		
		ResearchJournal journal = journals.get(choice-1);
		
		journal.addObserver(u);
		u.getJournals().add(journal);
		
		System.out.println("Subscribed to " + journal.getName());
		
		Database.getInstance().addLog(u, new Log(u.getUsername() + " subscribed to journal " + journal.getName()));
	}
	
	
	/**
     * Unsubscribes the user from a research journal.
     *
     * @param u The user to be unsubscribed.
     */
	public static void unsubscribeJournal(User u) {

		Vector<ResearchJournal> journals = u.getJournals();
		
		if(journals.isEmpty()) {
			System.out.println("No journals");
			return;
		}
		
		System.out.println("Enter 0 to return back");
		System.out.println("Choose journal:");
		
		printList(u.getJournals());
		
		int choice = validate(journals.size());
		
		if(choice == 0) {
			return;
		}
		
		ResearchJournal journal = journals.get(choice-1);
		
		journal.removeObserver(u);
		journals.remove(journal);
		
		System.out.println("Unsubscribed from " + journal.getName());
		
		Database.getInstance().addLog(u, new Log(u.getUsername() + " unsubscribed from journal " + journal.getName()));
	}
}
