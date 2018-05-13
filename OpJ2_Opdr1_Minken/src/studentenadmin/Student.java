package studentenadmin;

/**
 * Klasse verantwoordelijk voor het beheer van de diverse soorten studenten
 * @author Steven Minken
 */

public abstract class Student {
  
  /**
   * attribuut voor het bijhouden van de namen van de studenten of scholers
   */
  private String naam = null;

  /**
   * initialiseert de van naam de student
   * @param naam naam van de student
   */
  protected Student(String naam)  {
    this.naam = naam;
  }
  
  /**
   * Retourneert de naam van de reguliere student of scholer
   * @return String naam van de student
   */
  protected String getNaam() {
    return naam;
  }
  
  /**
   * Verwacht wordt dat de diverse studerenden een methode implementeren om diverse 
   * informatie weer te geven als String
   */
  @Override
  public abstract String toString();
  
}
