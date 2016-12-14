/**
 * 
 */
package org.arpit.archat.client.view.javafx;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import org.arpit.archat.client.view.ARChatView;
import org.arpit.archat.client.view.Root;
import org.arpit.archat.client.view.ViewLocation;
import org.arpit.archat.client.view.ViewManager;

import com.google.inject.Inject;

/**
 * @author arpit
 *
 */
public class FXARChatView extends BorderPane implements ARChatView{
	
	protected final ViewManager viewManager;
	protected final Stage stage;
	
	@Inject
	public FXARChatView(ViewManager viewManager, @Root Stage stage) {
		this.stage = stage;
		this.viewManager = viewManager;
	}

	@Override
	public void attachChild(Object subView, ViewLocation location) {
		// Only support (non-null) JavaFX Nodes
		if (!(subView instanceof Node)) {
			throw new IllegalArgumentException("subView must be an instance of " + Node.class.getName());
		}
		switch (location) {
		case LOGIN:
			setCenter((Node) subView);
			break;
		case NAVIGATION:
			setCenter((Node) subView);
			break;
		case REGISTER :
			setCenter((Node) subView);
			break;
		default:
			throw new IllegalArgumentException("location " + location + " is not supported");
		}
	}

	@Override
	public void detachChild(Object subView) {
		if (getCenter() == subView) {
			setCenter(null);
		} else if (getBottom() == subView) {
			setBottom(null);
		}
	}

	@Override
	public void attach() {
		setPrefSize(350, 600);
		// The root view is embedded in the main window
		Scene scene = new Scene(this);
		//scene.getStylesheets().addAll(CSS);
		stage.setScene(scene);
		// Register the location of the sub-view
		viewManager.registerLocations(this, ViewLocation.LOGIN, ViewLocation.NAVIGATION, ViewLocation.REGISTER);
	}

	@Override
	public void detach() {
		throw new UnsupportedOperationException("Cannot detach root view");
	}

	@Override
	public void done() {
		// not applicable
	}

}
