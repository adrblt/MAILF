package Groupe1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ville {
	private String nom;
	private int nbHab;
	private Commerce com;
	private List<Quartier> quartiers;
	
	public Ville() {
		this.nom = "";
		this.nbHab = 0;
		quartiers = new ArrayList<Quartier>();
	}
	
	public Ville(String nom, int nbHab) {
		this.nom = nom;
		this.nbHab = nbHab;
		this.quartiers = new ArrayList<Quartier>();
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		if (!nom.equals(""))
			this.nom = nom;
	}
	
	public int getNbHab() {
		return this.nbHab;
	}

	public void setNbHab(int nbHab) {
		if (nbHab > 0)
			this.nbHab = nbHab;
	}
	
	public Commerce getCommerce() {
		return this.com;
	}

	public void setCommerce(Commerce com) {
		this.com = com;
	}
	
	public List<Quartier> getQuartiers() {
		return Collections.unmodifiableList(this.quartiers);
	}
	
	public Quartier getQuartier(int i) {
		return quartiers.get(i);
	}
	
	public void add(Quartier q) {
		if (!this.quartiers.contains(q))
			this.quartiers.add(q);
		if (q.getVille() != this)
			q.setVille(this);
	}
	
	public void remove(Quartier q) {
		if (this.quartiers.contains(q))
			this.quartiers.remove(q);
	}
	
	public double impot(double prixUnitaire, double taux) {
		if (prixUnitaire >= 1)
			return prixUnitaire * this.nbHab + this.com.prix(taux);
		else
			return 0;
	}

}
