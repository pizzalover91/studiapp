package de.studiapp.pms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Administration {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long id;
	private String fach;
	private String prof;
	private String terminold;
	private String terminnew;
	
	public long getId( ) {
		return id;
	}

	public String getFach() {
		return fach;
	}

	public void setFach(String fach) {
		this.fach = fach;
	}

	public String getProf() {
		return prof;
	}

	public void setProf(String prof) {
		this.prof = prof;
	}

	public String getTerminold() {
		return terminold;
	}

	public void setTerminold(String terminold) {
		this.terminold = terminold;
	}

	public String getTerminnew() {
		return terminnew;
	}

	public void setTerminnew(String terminnew) {
		this.terminnew = terminnew;
	}
}
