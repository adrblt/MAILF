package Groupe2;
import java.util.Observable;
import java.util.Observer;

import DsgnP.*;
import Groupe1.*;

public class Driver implements IVisiteur, Observer {
	private String nom;
	private int age;
	private int nbHeures;
	public Taxi taxi;
	private Quartier quartier;
	private IStrategy strg;
	
	public Driver() {
		this.nom = "John Doe";
		this.age = 30;
		this.nbHeures = 35;
		this.taxi = null;
		this.quartier = null;
		this.strg = null;
	}

	public Driver(String nom, int age, int nbHeures) {
		this.nom = nom;
		this.age = age;
		this.nbHeures = nbHeures;
		this.taxi = null;
		this.quartier = null;
		this.strg = null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getNbHeures() {
		return nbHeures;
	}

	public void setNbHeures(int nbHeures) {
		this.nbHeures = nbHeures;
	}

	public Taxi getTaxi() {
		return taxi;
	}

	public void setTaxi(Taxi taxi) {
		if(this.taxi == null || taxi == null)
			this.taxi = taxi;
		else{
			this.taxi.setDriver(null);
			this.taxi = taxi;
		}
		if(taxi != null){
			if(this.taxi.getDriver() != this)
				this.taxi.setDriver(this);
		}
	}

	public Quartier getQuartier() {
		return quartier;
	}

	public IStrategy getStrg() {
		return strg;
	}

	public void IncrementAge() {
		this.age++;
	}

	public void DecrementNbHeures(int d) {
		if(this.nbHeures - d > 0)
			this.nbHeures-=d;
	}

	public void IncrementNbHeures(int i) {
		this.nbHeures+=i;
	}
	
	public void quitQuartier(){
		this.quartier.deleteObserver(this);
		this.quartier.subDriver();
		this.quartier = null;
	}
	
	public void setStrategy(double v){
		if (v > 0.5)
			this.strg = new MotoStrg();
		else
			this.strg = new VoitureStrg();
	}

	@Override
	public void visit(Quartier q) {
		this.quartier = q;
		this.setStrategy(q.getpEmb());
	}

	@Override
	public void update(Observable o, Object arg) {
		this.setStrategy((double) arg);
	}

}
