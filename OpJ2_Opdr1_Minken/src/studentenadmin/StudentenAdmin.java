package studentenadmin;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasse verantwoordelijk voor het beheer van de verschillende soorten studenten 
 * en voor het beheer van de diverse opleidingstrajecten
 * OpiJ2-Opdracht 1
 * @author Steven Minken
 */
public class StudentenAdmin {
  
  private List<Student> studentenLijst = null;
  private List<Opleiding> opleidingLijst = null;

  /**
   * Constructor voor het aanmaken van een studentenadministratie.
   * creert lege lijsten voor studenten en opleidingen, vult deze met 2 opleidingen en 3 CPP's
   */
  public StudentenAdmin() {
    studentenLijst = new ArrayList<Student>();
    opleidingLijst = new ArrayList<Opleiding>();
    
    maakOpleiding("Informatica", 200);
    maakOpleiding("Wiskunde", 160);
    
    maakCpp("CPP Java", 6);
    maakCpp("CPP Softwarearchitect", 4);
    maakCpp("CPP Systeemontwikkelaar", 3);  
  }
  
  /**
   * Maakt een nieuwe reguliere student aan en voegt deze toe aan
   * de studentenLijst.
   * @param naamStudent naam van de reguliere student
   * @param naamOpleiding naam van de opleiding
   */
  public void nieuweReguliereStudent(String naamStudent, String naamOpleiding) { 
    studentenLijst.add(new ReguliereStudent(naamStudent, getOpleiding(naamOpleiding))); 
  }
  
  /**
   * Maakt een nieuwe scholer aan en voegt deze toe aan
   * de studentenLijst.
   * @param naam naam van de scholer
   * @param naamCpp naam van het CPP
   */
  public void nieuweScholer(String naamScholer, String naamCpp) {
    studentenLijst.add(new Scholer(naamScholer, getOpleiding(naamCpp)));
  }
  
  /**
   * Maakt een nieuwe opleiding aan en voegt deze toe aan
   * de opleidingLijst.
   * @param naamOpleiding naam van de opleiding
   * @param double totaal van de te behalen studiepunten
   */
  public void maakOpleiding (String naamOpleiding, double totaalAantalStudiepunten) {
    ReguliereOpleiding reguliereOpleiding = new ReguliereOpleiding (naamOpleiding, totaalAantalStudiepunten);
    opleidingLijst.add(reguliereOpleiding);
  }
  
  /**
   * Maakt een nieuw cpp aan en voegt deze toe aan
   * de opleidingLijst.
   * @param naamCpp naam van het Cpp
   * @param int totaal te behalen modules
   */
  public void maakCpp (String naamCpp, int totaalAantalModules) {
    Cpp cpp = new Cpp (naamCpp, totaalAantalModules);
    opleidingLijst.add(cpp);
  }
  
  /**
   * Zoekt student bij gegeven naam.
   * @param naam naam van de student
   * @return Student student, null als student niet bestaat
   */
  private Student getStudent(String naam) {
    for (Student student : studentenLijst) {
      if (studentenLijst != null && student.getNaam().equals(naam)) {
        return student;
      }
    }
    return null;
  }
  
  /**
   * Zoekt opleiding van student.
   * @param naamOpleiding naam van de opleiding
   * @return Opleiding (null als opleiding niet bestaat)
   */
  private Opleiding getOpleiding(String naamOpleiding) {
    for (Opleiding opleiding : opleidingLijst) {
      if (opleidingLijst != null && opleiding.getNaamOpleiding().equals(naamOpleiding)) {
        return opleiding;
      }
    }
    return null;
  }
  
  /**
   * Verhoogt het aantal studiepunten van de reguliere student met een gegeven aantal
   */
  public void verhoogPunten(String naam, double punten)  {
    ReguliereStudent student = (ReguliereStudent) getStudent(naam);
    student.verhoogBehaaldeStudiepunten(punten);
  }
  
  /**
   * Voeg 1 module toe voor een scholer CPP
   */
  public void voegModuleToe(String naam)  {
    Scholer scholer = (Scholer) getStudent(naam);
    scholer.verhoogModules();
  }
  
  /**
   * Retourneert informatie van alle studenten
   * @return String String van informatie van studenten
   * 
   */
  public String toonAlleStudenten()  {
    StringBuilder studenten = new StringBuilder();
    for (Student s: studentenLijst)  {
      studenten.append(s.toString() + "\n");
    }
    return studenten.toString();
  }
  
  /**
   * Retourneert een array van de namen van alle beschikbare opleidingen.
   * @return String[] String[] van de namen van de opleidingen
   */
  public String[] getOpleidingen()  {
    ArrayList<String> opleidingen = new ArrayList<String>();
    for (Opleiding opleiding: opleidingLijst)  {
      if(opleiding instanceof ReguliereOpleiding)  {
        opleidingen.add(opleiding.getNaamOpleiding());
        }
      }
    String[] opleidingenArray = (String[]) opleidingen.toArray(new String[0]);
    return opleidingenArray;
  }
  
  /**
   * Retourneert een array van de namen van alle beschikbare CPP trajecten.
   * @return String[] String[] van de namen van de CPP trajecten
   */
  public String[] getCPP()  {
    ArrayList<String> Cpp = new ArrayList<String>();
    for (Opleiding opleiding: opleidingLijst)  {
      if(opleiding instanceof Cpp)  {
        Cpp.add(opleiding.getNaamOpleiding());
        }
      }
    String[] CppArray = (String[]) Cpp.toArray(new String[0]);
    return CppArray;
  }
  
  /**
   * Methode voor het weergeven van diverse informatie als String van een individuele student
   * @param naam naam van de student
   * @return String stringweergaven van de student
   */
  public String studentToString (String naam) {
    if (getStudent(naam) == null) {
    return null;
    } else {
      return getStudent(naam).toString();
    }
  }
  
}