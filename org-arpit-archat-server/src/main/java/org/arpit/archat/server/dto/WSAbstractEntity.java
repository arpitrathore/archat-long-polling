/**
 * 
 */
package org.arpit.archat.server.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.arpit.archat.common.dto.IAbstractEntity;

/**
 * @author Arpit.Rathore
 *
 */
@XmlRootElement(name = "abstractEntity")
public class WSAbstractEntity implements IAbstractEntity{
	private Long id;
	private Date lastModificationDate;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Date lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
}
