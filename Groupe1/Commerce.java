package Groupe1;

public class Commerce {
	private String nom;
	private double CA;
	
	public Commerce() {
		this.nom = "";
		this.CA = 0;
	}
	
	public Commerce(String nom, double CA) {
		this.nom = nom;
		this.CA = CA;
	}
	
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		if (!nom.equals(""))
			this.nom = nom;
	}
	
	public double getCA() {
		return this.CA;
	}

	public void setCA(double CA) {
		if (CA > 0)
			this.CA = CA;
	}
	
	public double prix(double taux) {
		if (taux >= 0)
			return taux * this.CA;
		else
			return 0;
	}
}
