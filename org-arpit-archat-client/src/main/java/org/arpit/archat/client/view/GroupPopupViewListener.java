/**
 * 
 */
package org.arpit.archat.client.view;

import java.util.List;

import org.arpit.archat.client.dto.FXUser;

/**
 * @author arpit
 *
 */
public interface GroupPopupViewListener {

	void onSave(String string, List<FXUser> selectedItems);

	void onCancel();

}
