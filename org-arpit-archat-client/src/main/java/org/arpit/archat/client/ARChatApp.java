/**
 * 
 */
package org.arpit.archat.client;

import javafx.application.Application;
import javafx.stage.Stage;

import org.arpit.archat.client.controller.Controller;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * @author arpit
 * 
 */
public class ARChatApp extends Application {
	private static ARChatApp instance;
	private Stage primaryStage;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		ARChatApp.instance = this;
		this.primaryStage = primaryStage;
		final Injector injector = Guice.createInjector((AbstractModule) Class.forName("org.arpit.archat.client.di.modules.ARChatModule")
				.newInstance());
		final Controller root = (Controller) injector.getInstance(Class.forName("org.arpit.archat.client.controller.ARChatController"));
		root.activate();
		primaryStage.setTitle("ARChat");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	/**
	 * Returns the main window.
	 * 
	 * @return the main window
	 */
	public Stage getStage() {
		return primaryStage;
	}

	/**
	 * Returns the {@link EMRApp} singleton instance.
	 * 
	 * @return the instance
	 */
	public static ARChatApp getInstance() {
		if (instance == null) {
			instance = new ARChatApp();
		}
		return instance;
	}
}
