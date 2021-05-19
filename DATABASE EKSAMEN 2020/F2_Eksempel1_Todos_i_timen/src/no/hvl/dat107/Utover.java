package no.hvl.dat107;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "idrett")
public class Utover {
	
	@Id private int medlemsNr;
	private String navn;
	private Date fodselsdato;
	private char kjonn;
	
		
	public Utover() {}
	

	public Utover(int medlemsNr, String navn, Date fodselsdato, char kjonn) {
		this.medlemsNr = medlemsNr;
		this.navn = navn;
		this.fodselsdato = fodselsdato;
		this.kjonn = kjonn;
	}

	
	public int getMedlemsNr() {
		return medlemsNr;
	}


	public void setMedlemsNr(int medlemsNr) {
		this.medlemsNr = medlemsNr;
	}


	public String getNavn() {
		return navn;
	}


	public void setNavn(String navn) {
		this.navn = navn;
	}


	public java.sql.Date getFodselsdato() {
		return fodselsdato;
	}


	public void setFodselsdato(java.sql.Date fodselsdato) {
		this.fodselsdato = fodselsdato;
	}


	public char getKjonn() {
		return kjonn;
	}


	public void setKjonn(char kjonn) {
		this.kjonn = kjonn;
	}


	@Override
	public String toString() {
		return "Utover [medlemsNr=" + medlemsNr + ", navn=" + navn + ", fodselsdato=" + fodselsdato + ", kjonn=" + kjonn
				+ "]";
	}
	
}
