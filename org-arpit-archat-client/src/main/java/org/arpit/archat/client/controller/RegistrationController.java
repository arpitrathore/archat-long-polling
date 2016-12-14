/**
 * 
 */
package org.arpit.archat.client.controller;


/**
 * @author arpit
 *
 */
public interface RegistrationController extends Controller {

	void addListener(RegistrationControllerListener loginControllerListener);

	void removeListener(RegistrationControllerListener loginControllerListener);
}
