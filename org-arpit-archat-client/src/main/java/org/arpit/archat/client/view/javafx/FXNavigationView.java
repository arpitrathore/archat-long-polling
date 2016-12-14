/**
 * 
 */
package org.arpit.archat.client.view.javafx;

import java.util.Collection;
import java.util.LinkedHashSet;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraintsBuilder;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.GridPaneBuilder;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.util.StringConverter;

import org.arpit.archat.client.dto.FXMessage;
import org.arpit.archat.client.dto.FXUser;
import org.arpit.archat.client.dto.FXUserGroup;
import org.arpit.archat.client.view.NavigationView;
import org.arpit.archat.client.view.NavigationViewListener;
import org.arpit.archat.client.view.ViewLocation;
import org.arpit.archat.client.view.ViewManager;
import org.arpit.archat.common.utility.DateTimeUtility;

import com.google.inject.Inject;

/**
 * @author arpit
 *
 */
public class FXNavigationView extends BorderPane implements NavigationView {
	protected final Collection<NavigationViewListener> listeners = new LinkedHashSet<NavigationViewListener>();
	private ViewManager viewManager;
	ScrollPane scrollPane = new ScrollPane();
	private TextArea chatTextArea = new TextArea();
	private VBox chatContainer = new VBox();
	private ComboBox<FXUser> userBox;
	private ComboBox<FXUserGroup> userGroupBox;
	private Button groupButton = new Button("G");

	@Inject
	public FXNavigationView(ViewManager viewManager) {
		super();
		this.viewManager = viewManager;
		chatTextArea.setPrefHeight(100);
		setPadding(new Insets(5));

		chatContainer.setPadding(new Insets(5));
		VBox.setVgrow(chatContainer, Priority.ALWAYS);

		chatTextArea.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER) {
					for (NavigationViewListener listener : listeners) {
						listener.onClickEnter(chatTextArea.getText().replace(
								"\n", ""));
					}
					chatTextArea.clear();
				}
			}
		});
		
		groupButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				for (NavigationViewListener listener : listeners) {
					listener.onClickGroup();
				}
			}
		});
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
		init();
		viewManager.attach(this, ViewLocation.NAVIGATION);
	}

	private void init() {
		scrollPane
				.setStyle("-fx-background-color:transparent;-fx-background-insets:0");
		scrollPane.setContent(chatContainer);
		setTop(getTopPane());
		setCenter(scrollPane);
		setBottom(chatTextArea);
	}

	private GridPane getTopPane() {
		final GridPane gridPane = GridPaneBuilder.create().hgap(10).vgap(10)
				.build();
		gridPane.addRow(0, new Label("Groups : "), getGroupBox(), groupButton);
		gridPane.addRow(1, new Label("Users : "), getUserBox());
		return gridPane;
	}

	private ComboBox<FXUser> getUserBox() {
		if (userBox == null) {
			userBox = new ComboBox<FXUser>();
			userBox.setPrefWidth(240);
			userBox.setConverter(new StringConverter<FXUser>() {
				@Override
				public String toString(FXUser user) {
					if (user != null) {
						return user.getFirstName() + " " + user.getLastName();
					}
					return null;
				}

				@Override
				public FXUser fromString(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
			});
			userBox.getSelectionModel().selectedItemProperty()
					.addListener(new ChangeListener<FXUser>() {
						@Override
						public void changed(
								ObservableValue<? extends FXUser> arg0,
								FXUser oldUser, FXUser newUser) {
							getGroupBox().getSelectionModel().clearSelection();
						}
					});
		}
		return userBox;
	}

	private ComboBox<FXUserGroup> getGroupBox() {
		if (userGroupBox == null) {
			userGroupBox = new ComboBox<FXUserGroup>();
			userGroupBox.setPrefWidth(240);
			userGroupBox.setConverter(new StringConverter<FXUserGroup>() {
				@Override
				public String toString(FXUserGroup userGroup) {
					if (userGroup != null) {
						return userGroup.getName();
					}
					return null;
				}

				@Override
				public FXUserGroup fromString(String arg0) {
					// TODO Auto-generated method stub
					return null;
				}
			});
			userGroupBox.getSelectionModel().selectedItemProperty()
					.addListener(new ChangeListener<FXUserGroup>() {
						@Override
						public void changed(
								ObservableValue<? extends FXUserGroup> arg0,
								FXUserGroup oldUserGroup,
								FXUserGroup newUserGroup) {
							getUserBox().getSelectionModel().clearSelection();
						}
					});
		}
		return userGroupBox;
	}

	@Override
	public void detach() {
		viewManager.unregisterLocations(this);
		viewManager.detach(this, ViewLocation.NAVIGATION);
	}

	@Override
	public void done() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(NavigationViewListener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(NavigationViewListener listener) {
		this.listeners.remove(listener);
	}

	@Override
	public void setUsers(ObservableList<FXUser> users) {
		getUserBox().setItems(users);
	}

	@Override
	public void setGroups(ObservableList<FXUserGroup> groups) {
		getGroupBox().setItems(groups);
	}

	@Override
	public void setMessages(ObservableList<FXMessage> messages) {
		chatContainer.getChildren().clear();
		DoubleProperty wProperty = new SimpleDoubleProperty();
		wProperty.bind(chatContainer.heightProperty());
		wProperty.addListener(new InvalidationListener() {
			@Override
			public void invalidated(Observable arg0) {
				scrollPane.setVvalue(scrollPane.getVmax());
			}
		});
		for (FXMessage message : messages) {
			GridPane gridPane = new GridPane();
			gridPane.setGridLinesVisible(false);
			gridPane.setHgap(10);
			gridPane.getColumnConstraints().addAll(
					ColumnConstraintsBuilder.create().percentWidth(15)
							.halignment(HPos.RIGHT).build(),
					ColumnConstraintsBuilder.create().percentWidth(75).build(),
					ColumnConstraintsBuilder.create().percentWidth(10).build());
			gridPane.setPrefWidth(318);

			Label name = new Label(message.getSender().getFirstName());
			Label text = new Label(message.getText());
			Label time = new Label(DateTimeUtility.convertToTime(message
					.getLastModificationDate()));
			time.setStyle("-fx-text-fill:gray");
			gridPane.addRow(0, name, text, time);

			chatContainer.getChildren().add(gridPane);
		}
	}

	@Override
	public FXUser getSelectedUser() {
		return getUserBox().getSelectionModel().getSelectedItem();
	}

	@Override
	public FXUserGroup getSelectedUserGroup() {
		return getGroupBox().getSelectionModel().getSelectedItem();
	}
}
