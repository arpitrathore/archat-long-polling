/**
 * 
 */
package org.arpit.archat.integration.utility;

import java.util.Date;

import org.arpit.archat.integration.domain.IntMessage;
import org.arpit.archat.integration.domain.IntUser;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * @author arpit.rathore
 * 
 */
public class TestDataUtility {

//	public static void main(String[] args) {
//
//		IntUser user = new IntUser();
//		user.setBirthDate(new Date());
//		user.setUserName("USER1");
//		user.setGender("MALE");
//		user.setCurrentEmail("user1@gmail.com");
//
//		IntUser user2 = new IntUser();
//		user2.setUserName("USER2");
//		user2.setBirthDate(new Date());
//		user2.setGender("MALE");
//		user2.setCurrentEmail("user2@gmail.com");
//
//		Client client = Client.create();
//
//		WebResource webResource = client
//				.resource("http://localhost:8080/org-arpit-archat-server/rest/users/createUser");
//
//		ClientResponse response = webResource.type("application/json").post(
//				ClientResponse.class, user);
//
//		IntUser createdUser1 = response.getEntity(IntUser.class);
//
//		ClientResponse response2 = webResource.type("application/json").post(
//				ClientResponse.class, user2);
//
//		IntUser createdUser2 = response2.getEntity(IntUser.class);
//
//		System.out.println(createdUser1);
//		System.out.println(createdUser2);
//
//		WebResource webResource2 = client
//				.resource("http://localhost:8080/org-arpit-archat-server/rest/messages/createMessage");
//		IntMessage m1 = new IntMessage();
//		m1.setReceiver(createdUser1);
//		m1.setSender(createdUser2);
//		m1.setText("11111111111111111111");
//		m1.setRecievedDate(new Date());
//
//		IntMessage m2 = new IntMessage();
//		m2.setReceiver(createdUser2);
//		m2.setSender(createdUser1);
//		m2.setText("22222222222222222222");
//		m2.setRecievedDate(new Date());
//
//		ClientResponse mr1 = webResource2.type("application/json").post(
//				ClientResponse.class, m1);
//		IntMessage intm1 = mr1.getEntity(IntMessage.class);
//		System.out.println(intm1);
//
//		ClientResponse mr2 = webResource2.type("application/json").post(
//				ClientResponse.class, m2);
//		IntMessage intm2 = mr2.getEntity(IntMessage.class);
//		System.out.println(intm2);
//	}

}
