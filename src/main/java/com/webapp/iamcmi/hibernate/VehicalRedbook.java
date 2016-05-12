package com.webapp.iamcmi.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicalRedbook")
public class VehicalRedbook {
	@Id
	@GeneratedValue
	private int vehIDPK;
	@Column(name="VEH_Key")
	private String vehKey;
	@Column(name="VEH_MakeName")
	private String vehMakeName;
	
	public int getVehIDPK() {
		return vehIDPK;
	}
	public void setVehIDPK(int vehIDPK) {
		this.vehIDPK = vehIDPK;
	}
	public String getVehKey() {
		return vehKey;
	}
	public void setVehKey(String vehKey) {
		this.vehKey = vehKey;
	}
	public String getVehMakeName() {
		return vehMakeName;
	}
	public void setVehMakeName(String vehMakeName) {
		this.vehMakeName = vehMakeName;
	}
	
}
