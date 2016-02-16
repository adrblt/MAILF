package Groupe1;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import DsgnP.IVisiteur;

public class Quartier extends Observable {
	private String nom;
	private Ville ville;
	private int nbTaxi;
	private double pEmb;
	final static int seuil = 2;
	
	public Quartier() {
		this.nom = "";
		this.nbTaxi = 0;
		this.pEmb = 0;
		this.ville = null;
	}
	
	public Quartier(String nom) {
		this.nom = nom;
		this.nbTaxi = 0;
		this.pEmb = 0;
		this.ville = null;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		if (!nom.equals(""))
			this.nom = nom;
	}
	
	public Ville getVille() {
		return this.ville;
	}
	
	public int getNbTaxi() {
		return nbTaxi;
	}

	public double getpEmb() {
		return pEmb;
	}

	public void setpEmb(double pEmb) {
		this.pEmb = pEmb;
		setChanged();
		notifyObservers(this.pEmb);
	}

	public void setVille(Ville v2) {
		if (this.ville != null && !this.ville.equals(v2))
			this.ville.remove(this);
		this.ville = v2;
		if (!this.ville.getQuartiers().contains(this))
			this.ville.add(this);
	}
	
	public void subDriver(){
		if(this.nbTaxi > 0)
			this.nbTaxi--;
	}
	
	public int accept(IVisiteur vq){
		if(nbTaxi < seuil){
			this.addObserver((Observer) vq);
			vq.visit(this);
			nbTaxi++;
			return 0;
		}
		else{
			return -1;
		}
	}
}
