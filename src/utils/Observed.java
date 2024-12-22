package utils;

import wsp.*;

/**
 * The Observed interface represents an observable entity that can be observed by users.
 */
public interface Observed {
	
	/**
     * Adds an observer to the list of observers.
     *
     * @param observer The observer to be added.
     */
	void addObserver(User observer);
	
	/**
     * Removes an observer from the list of observers.
     *
     * @param observer The observer to be removed.
     */
	void removeObserver(User observer);
	
	/**
     * Notifies all observers about a change, passing information about the research paper and journal.
     *
     * @param paper The research paper associated with the notification.
     * @param rj    The research journal associated with the notification.
     */
	void notifyObservers(ResearchPaper paper, ResearchJournal rj);
}
