/**
 * 
 */
package org.arpit.archat.client.view.impl;

import java.util.HashMap;
import java.util.Map;

import org.arpit.archat.client.di.Context;
import org.arpit.archat.client.view.View;
import org.arpit.archat.client.view.ViewLocation;
import org.arpit.archat.client.view.ViewManager;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author arpit
 *
 */
@Singleton
public class ViewManagerImpl implements ViewManager {


	protected final Context context;

	private final Map<ViewLocation, View> locations = new HashMap<ViewLocation, View>();

	/**
	 * Creates a new {@link ViewManagerImpl}.
	 * 
	 * @param context
	 *            the global context to use
	 */
	@Inject
	public ViewManagerImpl(Context context) {
		this.context = context;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void registerLocation(final View view, final ViewLocation location) {
		if (locations.containsKey(location)) {
			throw new IllegalArgumentException(location.toString());
		}
		locations.put(location, view);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void registerLocations(final View view, final ViewLocation... locations) {
		for (ViewLocation location : locations) {
			registerLocation(view, location);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void unregisterLocation(final ViewLocation location) {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public synchronized void unregisterLocations(final View view) {
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void attach(final Object subView, final ViewLocation location) {
		if (!locations.containsKey(location)) {
			throw new IllegalArgumentException(location.toString());
		}
		locations.get(location).attachChild(subView, location);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void detach(final Object subView, final ViewLocation location) {
		if (!locations.containsKey(location)) {
			throw new IllegalArgumentException(location.toString());
		}
		locations.get(location).detachChild(subView);
	}
	
}
