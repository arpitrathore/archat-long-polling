/**
 * 
 */
package org.arpit.archat.client.service.impl;

import com.sun.jersey.api.client.Client;

/**
 * @author Arpit.Rathore
 *
 */
public abstract class GenericServiceImpl {
	//protected final String GENERIC_URL = "http://localhost:8080/org-arpit-archat-server/rest";
	protected final String GENERIC_URL = "http://172.51.31.43:8080/org-arpit-archat-server/rest";
	protected final Client client = Client.create();
}
