/**
 * 
 */
package org.arpit.archat.client;

/**
 * @author arpit
 *
 */
public interface HasListeners<T> {

	/**
	 * Adds a listener to the list of listeners.
	 * 
	 * @param listener
	 *            the listener to add
	 */
	void addListener(T listener);

	/**
	 * Adds a listener to the list of listeners.
	 * 
	 * @param listener
	 *            the listener to add
	 */
	void removeListener(T listener);

}
