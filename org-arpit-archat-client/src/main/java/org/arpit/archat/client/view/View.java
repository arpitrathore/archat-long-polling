/**
 * 
 */
package org.arpit.archat.client.view;

/**
 * @author arpit
 *
 */
public interface View {

	/**
	 * Attaches <code>subView</code> at <code>location</code>.
	 * 
	 * @param subView
	 *            the sub-view to attach to this view
	 * @param location
	 *            the location where to attach the sub-view
	 */
	void attachChild(Object subView, ViewLocation location);

	/**
	 * Detaches <code>subView</code> from <code>location</code>.
	 * 
	 * @param subView
	 *            the sub-view to detach from this view
	 * @param location
	 *            the location from which to detach the sub-view
	 */
	void detachChild(Object subView);
	
	/**
	 * Attaches this view from its parent view.
	 */
	void attach();
	
	/**
	 * Detaches this view from its parent view.
	 */
	void detach();

	/**
	 * Re-enables the view after a long-running activity. Most views will disable themselves when emitting an event to their listeners, as
	 * that event will trigger a long-running, asynchronous action. Invoke this method to notify the view that the action has finished.
	 */
	void done();

}
