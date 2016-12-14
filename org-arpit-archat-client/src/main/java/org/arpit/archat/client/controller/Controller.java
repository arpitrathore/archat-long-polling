/**
 * 
 */
package org.arpit.archat.client.controller;

/**
 * @author arpit
 *
 */
public interface Controller {

	/**
	 * Activates this controller. Attaches the view(s) managed by this controller, and also activates any nested controllers.
	 */
	void activate();

	/**
	 * Deactivates this controller. Detaches the view(s) managed by this controller, and also deactivates any nested controllers.
	 */
	void deactivate();
}
