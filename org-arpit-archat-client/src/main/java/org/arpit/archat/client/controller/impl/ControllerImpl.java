/**
 * 
 */
package org.arpit.archat.client.controller.impl;

import org.arpit.archat.client.controller.Controller;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author arpit
 *
 */
public abstract class ControllerImpl implements Controller {
	protected final Injector injector;

	@Inject
	public ControllerImpl(Injector injector) {
		this.injector = injector;
	}

}
