package Groupe2;

public class Taxi {
    private String immatriculation;
    private int annee;
    private int nbPassengers;
    private int nbMaxPassengers;
    public Driver driver;
    
    public Taxi() {
        this.immatriculation = "AA555AA";
        this.annee = 2015;
        this.nbPassengers = 0;
        this.nbMaxPassengers = 4;
        this.driver = null;
    }
    
    public Taxi(String immatriculation, int annee, int nbMaxPassengers) {
    	this.immatriculation = immatriculation;
    	this.annee = annee;
    	this.nbPassengers = 0;
    	this.nbMaxPassengers = nbMaxPassengers; 
    	this.driver = null;
    }

	public String getImmatriculation() {
		return immatriculation;
	}

	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getNbPassengers() {
		return nbPassengers;
	}

	public void setNbPassengers(int nbPassengers) {
		if(nbPassengers > 0 && this.nbMaxPassengers >= nbPassengers)
			this.nbPassengers = nbPassengers;
	}
	
    public void IncrementPassenger() { 
        if(this.nbPassengers < this.nbMaxPassengers)
            this.nbPassengers++ ; 
    }   
    
    public void DecrementPassenger() { 
        if(this.nbPassengers > 0)
            this.nbPassengers-- ; 
    } 

	public int getNbMaxPassengers() {
		return nbMaxPassengers;
	}

	public void setNbMaxPassengers(int nbMaxPassengers) {
		this.nbMaxPassengers = nbMaxPassengers;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		if(this.driver == null || driver == null)
			this.driver = driver;
		else{
			this.driver.setTaxi(null);
			this.driver = driver;
		}
		if(driver != null){
			if(this.driver.getTaxi() != this)
				this.driver.setTaxi(this);
		}
	}
    
}
