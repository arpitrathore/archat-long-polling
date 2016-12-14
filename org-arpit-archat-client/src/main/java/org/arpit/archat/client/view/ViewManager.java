/**
 * 
 */
package org.arpit.archat.client.view;

/**
 * @author arpit
 *
 */
public interface ViewManager {

	/**
	 * Registers <code>location</code> as provided by <code>view</code>. This means that <code>view</code> knows how to embed child views
	 * within itself at the place symbolically indicated by <code>location</code>. Example: {@link CareConnectView} knows how to embed (any)
	 * child {@link View} at {@link ViewLocation#LOGIN}.
	 * 
	 * @param view
	 *            the view that provides the given location
	 * @param location
	 *            the provided location
	 */
	void registerLocation(final View view, final ViewLocation location);

	/**
	 * Registers all <code>locations</code> as provided by <code>view</code>.
	 * 
	 * @param view
	 *            the view that provides the given location
	 * @param locations
	 *            the provided locations
	 * @see #registerLocation(View, ViewLocation)
	 */
	void registerLocations(final View view, final ViewLocation... locations);

	/**
	 * Unregisters <code>location</code>. Removes <code>location</code> from the internal lookup table, such that child views can no longer
	 * attach to it via this view manager.
	 * 
	 * @param location
	 *            the provided location
	 */
	void unregisterLocation(final ViewLocation location);

	/**
	 * Unregisters all locations provided by <code>view</code>. Remove all {@link ViewLocation}s previously registered by <code>view</code>,
	 * such that child views can no longer attach to it via this view manager.
	 * 
	 * @param view
	 *            the view that provides the locations
	 * @see #registerLocation(View, ViewLocation)
	 */
	void unregisterLocations(final View view);

	/**
	 * Attaches <code>subView</code> at <code>location</code>. This view manager forwards the request to the parent {@link View} that has
	 * previously registered <code>location</code> by invoking {@link View#attachChild(Object, ViewLocation)} on that parent {@link View}.
	 * 
	 * @param subView
	 *            the sub-view to attach to a parent view
	 * @param location
	 *            the location where to attach the sub-view
	 * @throws ViewLocationNotBoundException
	 *             if <code>location</code> is not registered in this view manager
	 */
	void attach(final Object subView, final ViewLocation location);

	/**
	 * Detaches <code>subView</code> from <code>location</code>. This view manager forwards the request to the parent {@link View} that has
	 * previously registered <code>location</code> by invoking {@link View#detachChild(Object)} on that parent {@link View}.
	 * 
	 * @param subView
	 *            the sub-view to detach from a parent view
	 * @param location
	 *            the location from which to detach the sub-view
	 * @throws ViewLocationNotBoundException
	 *             if <code>location</code> is not registered in this view manager
	 */
	void detach(final Object subView, final ViewLocation location);
}
