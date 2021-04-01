package no.hvl.dat102.klient;

import no.hvl.dat102.KjedetBSTre;

import java.util.Random;

public class KlientBSTre {



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random terning = new Random();
		int tall = terning.nextInt();
		int total = 0;
		int hoyde = -1;
		int minstehoyde = Integer.MAX_VALUE;
		int makshoyde = Integer.MIN_VALUE;
		int totalhoyde = 0;
		KjedetBSTre[] bstab = new KjedetBSTre[100];
		for (int l = 0; l < 100; l++) {
			KjedetBSTre bstre = new KjedetBSTre();
			bstab[l] = bstre;
			for (int i = 0; i < 1023; i++) {
				bstre.leggTil(tall);
				tall = terning.nextInt();
			}
		}
		for (int o = 0; o < bstab.length; o++){

			hoyde = bstab[o].hoyde();
			if(minstehoyde > hoyde){
				minstehoyde = hoyde;
			}
			if(makshoyde < hoyde){
				makshoyde = hoyde;
			}
			totalhoyde += hoyde;
			total += bstab[o].antall();
		}
		System.out.println("Totalt noder: "+total);
		System.out.println("Minste høyde: "+minstehoyde);
		System.out.println("Maks høyde: "+makshoyde);
		System.out.println("Teoretisk minste høyde: "+teoretiskMin(1023));
		System.out.println("Teoretisk maks høyde: "+teoreiskMaks(1023));
		System.out.println("Gjennomsnittlig høyde: "+totalhoyde / bstab.length);
	}
	public static int teoretiskMin(int n){

		int result = (int)(Math.log(n)/Math.log(2));
		return result;
	}
	public static int teoreiskMaks(int n){
		return n-1;
	}
}
