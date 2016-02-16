package TestUnitaires;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import Groupe1.*;
import Groupe2.*;

public class TestU {
	private Ville ville1;
	private Ville ville2;
	private Quartier quartier1;
	private Quartier quartier2;
	private Commerce commerce1;
	private Commerce commerce2;
	
	private Taxi taxi1;
	private Taxi taxi2;
	private Driver driver1;
	private Driver driver2;
	private Driver driver3;
	

	@Before
    public void setUp() {
    	ville1 = new Ville("VILLE_A", 50);
    	ville2 = new Ville();
    	
    	quartier1 = new Quartier("QUARTIER_1");
    	quartier2 = new Quartier();
    	
    	commerce1 = new Commerce("COMMERCE_1", 1000);
    	commerce2 = new Commerce();
    	
    	driver1 = new Driver("DRIVER_A", 20, 40);
    	driver2 = new Driver();
    	driver3 = new Driver();
    	
    	taxi1 = new Taxi("AZ555ZA", 2002, 4);
    	taxi2 = new Taxi();
    }
	
	@Test
	public void testVille() {
		assertEquals(ville1.getNom(), "VILLE_A");
		assertEquals(ville1.getNbHab(), 50);
		
		ville2.setNom("VILLE_B");
		ville2.setNbHab(60);
		
		assertEquals(ville2.getNom(), "VILLE_B");
		assertEquals(ville2.getNbHab(), 60);
		
		ville2.setNom("");
		ville2.setNbHab(-10);
		
		assertEquals(ville2.getNom(), "VILLE_B");
		assertEquals(ville2.getNbHab(), 60);
		
		ville1.setCommerce(commerce1);
		assertEquals(ville1.getCommerce(), commerce1);
		
		assertEquals(ville1.impot(50, 0.3), 2800, 0);
		assertEquals(ville1.impot(-100, 0.3), 0, 0);
	}
	
	@Test
	public void testQuartier() {
		assertEquals(quartier1.getNom(), "QUARTIER_1");
		
		quartier2.setNom("QUARTIER_2");
		
		assertEquals(quartier2.getNom(), "QUARTIER_2");
		
		quartier2.setNom("");
		
		assertEquals(quartier2.getNom(), "QUARTIER_2");
	}
	
	@Test
	public void testCommerce() {
		assertEquals(commerce1.getNom(), "COMMERCE_1");
		assertEquals(commerce1.getCA(), 1000, 0);
		
		commerce2.setNom("COMMERCE_2");
		commerce2.setCA(500);
		
		assertEquals(commerce2.getNom(), "COMMERCE_2");
		assertEquals(commerce2.getCA(), 500, 0);
		
		commerce2.setNom("");
		commerce2.setCA(-10);
		
		assertEquals(commerce2.getNom(), "COMMERCE_2");
		assertEquals(commerce2.getCA(), 500, 0);
		
		assertEquals(commerce1.prix(0.3), 300, 0);
		assertEquals(commerce1.prix(-1), 0, 0);
	}
	
	@Test
	public void testChangeQ() {
		ville1.add(quartier1);
		assertTrue(ville1.getQuartiers().contains(quartier1));
		assertEquals(ville1.getQuartier(0), quartier1);
		assertEquals(quartier1.getVille(), ville1);
		
		ville1.add(quartier1);
		assertEquals(ville1.getQuartiers().size(), 1);
		
		ville1.remove(quartier2);
		assertEquals(ville1.getQuartiers().size(), 1);
		
		quartier1.setVille(ville2);

		assertTrue(!ville1.getQuartiers().contains(quartier1));
		assertTrue(!quartier1.getVille().equals(ville1));
		assertTrue(ville2.getQuartiers().contains(quartier1));
		assertEquals(quartier1.getVille(), ville2);
	}
	
	@Test
	public void testDriver() {
		assertEquals(driver1.getNom(), "DRIVER_A");
		assertEquals(driver1.getAge(), 20);
		assertEquals(driver1.getNbHeures(), 40);
		
		driver2.setNom("DRIVER_B");
		driver2.setAge(40);
		driver2.setNbHeures(45);
		
		assertEquals(driver2.getNom(), "DRIVER_B");
		assertEquals(driver2.getAge(), 40);
		assertEquals(driver2.getNbHeures(), 45);
		
		driver2.DecrementNbHeures(3);
		driver1.IncrementNbHeures(2);
		driver1.IncrementAge();
		
		assertEquals(driver2.getNbHeures(), 42);
		assertEquals(driver1.getAge(), 21);
		assertEquals(driver1.getNbHeures(), 42);
		
		driver2.DecrementNbHeures(45);
		assertEquals(driver2.getNbHeures(), 42);
	}
	
	@Test
	public void testTaxi() {
		assertEquals(taxi1.getImmatriculation(), "AZ555ZA");
		assertEquals(taxi1.getAnnee(), 2002);
		assertEquals(taxi1.getNbMaxPassengers(), 4);
		assertEquals(taxi1.getNbPassengers(), 0);
		
		taxi2.setImmatriculation("BT500GH");
		taxi2.setAnnee(2005);
		taxi2.setNbMaxPassengers(2);
		
		assertEquals(taxi2.getImmatriculation(), "BT500GH");
		assertEquals(taxi2.getAnnee(), 2005);
		assertEquals(taxi2.getNbMaxPassengers(), 2);
		assertEquals(taxi2.getNbPassengers(), 0);
		
		taxi1.setNbPassengers(5);
		assertEquals(taxi1.getNbPassengers(), 0);
		taxi1.setNbPassengers(-5);
		assertEquals(taxi1.getNbPassengers(), 0);
		taxi1.DecrementPassenger();
		assertEquals(taxi1.getNbPassengers(), 0);
		taxi1.setNbPassengers(3);
		assertEquals(taxi1.getNbPassengers(), 3);
		taxi1.IncrementPassenger();
		assertEquals(taxi1.getNbPassengers(), 4);
		taxi1.IncrementPassenger();
		assertEquals(taxi1.getNbPassengers(), 4);
		taxi1.DecrementPassenger();
		assertEquals(taxi1.getNbPassengers(), 3);
	}
	
	@Test
	public void testChangeT() {
		driver1.setTaxi(taxi1);
		assertEquals(driver1.getTaxi(), taxi1);
		assertEquals(taxi1.getDriver(), driver1);
		
		taxi1.setDriver(driver2);
		assertEquals(taxi1.getDriver(), driver2);
		assertEquals(driver2.getTaxi(), taxi1);
		
		driver2.setTaxi(taxi2);
		assertEquals(driver2.getTaxi(), taxi2);
		assertEquals(taxi2.getDriver(), driver2);
	}
	
	@Test
	public void testDsgnP() {
		quartier1.setpEmb(0.45);
		assertEquals(quartier1.accept(driver1), 0);
		assertEquals(quartier1.getNbTaxi(), 1);
		assertEquals(driver1.getQuartier(), quartier1);
		assertEquals(driver1.getStrg().strategy(), "voiture");
		
		quartier1.setpEmb(0.70);
		assertEquals(quartier1.accept(driver2), 0);
		assertEquals(quartier1.getNbTaxi(), 2);
		assertEquals(driver2.getStrg().strategy(), "moto");
		assertEquals(driver1.getStrg().strategy(), "moto");
		
		assertEquals(quartier1.accept(driver3), -1);
		assertEquals(driver3.getQuartier(), null);
		
		driver2.quitQuartier();
		assertEquals(quartier1.getNbTaxi(), 1);
		assertEquals(driver2.getQuartier(), null);
	}
}
