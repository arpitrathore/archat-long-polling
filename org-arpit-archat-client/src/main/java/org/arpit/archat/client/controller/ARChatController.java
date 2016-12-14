/**
 * 
 */
package org.arpit.archat.client.controller;

/**
 * @author arpit
 *
 */
public interface ARChatController extends Controller{
	/**
	 * Adds an {@link NavigationControllerListener} to the list of listeners.
	 * 
	 * @param listener
	 *            the listener to add
	 */
	void addListener();

	/**
	 * Removes an {@link NavigationControllerListener} from the list of listeners.
	 * 
	 * @param listener
	 *            the listener to remove
	 */
	void removeListener();
}
