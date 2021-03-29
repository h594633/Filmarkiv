package no.hvl.dat107;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Ansatt", schema = "oblig3")
public class Ansatt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int ansNr;
	public String brukernavn, fornavn, etternavn, ansettelsesdato, stilling;
	public BigDecimal maanedslonn;

	
	
	
	@Override
	public String toString() {
		return "Ansattnummer " + ansNr + "\t\tlønn: " + maanedslonn + "\tbrukernavn: " + brukernavn + "\t\ttnavn: " + fornavn
				+ " " + etternavn + "\tble ansatt: " + ansettelsesdato + "\tstilling:" + stilling;
	}
	
	public void skrivUt() {
		System.out.println(this.toString());
	}

	public int getAnsNr() {
		return ansNr;
	}

	public void setAnsNr(int ansNr) {
		this.ansNr = ansNr;
	}

	public BigDecimal getMaanedslonn() {
		return maanedslonn;
	}

	public void setMaanedslonn(BigDecimal maanedslonn2) {
		this.maanedslonn = maanedslonn2;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getAnsDato() {
		return ansettelsesdato;
	}

	public void setAnsDato(String ansDato) {
		this.ansettelsesdato = ansettelsesdato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

}
