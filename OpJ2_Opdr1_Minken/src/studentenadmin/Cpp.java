package studentenadmin;

/**
 * Klasse verantwoordelijk voor het beheer van de diverse CPP trajecten
 * @author Steven Minken
 */

public class Cpp extends Opleiding {
  
  /**
   * Attribuut voor het vastleggen van het totaal aantal modules voor een CPP
   */
  private int totaalModules = 0;
  
  /**
   * Constructor voor het aanmaken van een nieuw CPP
   * @param naam naam van het CPP
   * @param aantalModules aantal modules van het CPP
   */
  protected Cpp(String naamCpp, int totaalAantalModules) {
    super(naamCpp);
    totaalModules = totaalAantalModules;
  }

  /**
   * Verhoogt het aantal modules
   */
  protected void verhoogModules() {
    totaalModules += 1;
  }
  
  /**
   * Retourneert het totaal aantal modules van het CPP Java
   * @return int het aantal modules
   */
  protected int getAantalModules()  {
    return totaalModules;
  }
  
  /**
   * Geeft een Stringweergave van dit CPP van de naam van het CPP en het totaal aantal modules
   * @return String String van dit CPP
   */
  @Override
  public String toString()  {
    return  "CPP: " + getNaamOpleiding() + ", totaal modules: " + totaalModules;
  }
  
}
