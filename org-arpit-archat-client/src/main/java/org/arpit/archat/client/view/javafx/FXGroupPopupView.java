/**
 * 
 */
package org.arpit.archat.client.view.javafx;

import java.util.Collection;
import java.util.LinkedHashSet;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ListViewBuilder;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPaneBuilder;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.stage.Modality;
import javafx.stage.Stage;

import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.view.GroupPopupView;
import org.arpit.archat.client.view.GroupPopupViewListener;
import org.arpit.archat.client.view.ViewLocation;

import com.google.inject.Inject;

/**
 * @author arpit
 *
 */
public class FXGroupPopupView extends Stage implements GroupPopupView {

	private final Collection<GroupPopupViewListener> listeners = new LinkedHashSet<GroupPopupViewListener>();
	private Stage stage;

	private TextField nameField = new TextField();
	private HBox topBar;
	private HBox bottomBar;
	private ListView<FXUser> listView;

	@Inject
	public FXGroupPopupView(Stage stage) {
		this.stage = stage;

		setScene(new Scene(getContent()));
		initModality(Modality.WINDOW_MODAL);
		setTitle("Create Group");
	}

	private Parent getContent() {
		return BorderPaneBuilder.create().top(getTop()).center(getUsersList()).bottom(getBottom()).minHeight(400).minWidth(400).build();
	}

	private Node getTop() {
		if (topBar == null) {
			topBar = HBoxBuilder.create().children(new Label("Group Name : "), nameField).padding(new Insets(10)).spacing(15).build();
		}
		return topBar;
	}

	private ListView<FXUser> getUsersList() {
		if (listView == null) {
			listView = ListViewBuilder.<FXUser> create().build();
			listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		}
		return listView;
	}

	private Node getBottom() {
		if (bottomBar == null) {
			Button saveBotton = new Button("Save");
			saveBotton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					for (GroupPopupViewListener listener : listeners) {
						listener.onSave(nameField.getText(), getUsersList().getSelectionModel().getSelectedItems());
					}
				}
			});

			Button cancelBotton = new Button("Cancel");
			cancelBotton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent arg0) {
					for (GroupPopupViewListener listener : listeners) {
						listener.onCancel();
					}
				}
			});

			bottomBar = HBoxBuilder.create().children(cancelBotton, saveBotton).padding(new Insets(10)).spacing(15)
					.alignment(Pos.CENTER_RIGHT).build();
		}

		return bottomBar;
	}

	@Override
	public void attachChild(Object subView, ViewLocation location) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void detachChild(Object subView) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void attach() {
		getUsersList().getSelectionModel().clearSelection();
		nameField.clear();
		show();
	}

	@Override
	public void detach() {
		hide();
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(GroupPopupViewListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(GroupPopupViewListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void setUsers(ObservableList<FXUser> users) {
		getUsersList().setItems(users);
	}

}
