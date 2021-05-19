package no.hvl.dat107;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "idrett")
public class Lop {
	
	@Id private int lopsNr;
	private String sted;
	private Date lopsDato;
	private int distance;
	
	public Lop() {}
	
	public Lop(int lopsNr, String sted, Date lopsDato, int distance) {
		super();
		this.lopsNr = lopsNr;
		this.sted = sted;
		this.lopsDato = lopsDato;
		this.distance = distance;
	}

	public int getLopsNr() {
		return lopsNr;
	}

	public void setLopsNr(int lopsNr) {
		this.lopsNr = lopsNr;
	}

	public String getSted() {
		return sted;
	}

	public void setSted(String sted) {
		this.sted = sted;
	}

	public Date getLopsDato() {
		return lopsDato;
	}

	public void setLopsDato(Date lopsDato) {
		this.lopsDato = lopsDato;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "Lop [lopsNr=" + lopsNr + ", sted=" + sted + ", lopsDato=" + lopsDato + ", distance=" + distance + "]";
	}
	
	
		

	
}
