/**
 * Programm, um eine Mathematische Funktion für den Numbercruncher auszuwählen und dann ausführen.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 *
 * @version 1.0
 */
public abstract class NumberCruncher implements CrunchOperation {

  /**
   * Hier wird abhängig vom Benutzer eine Mathematische Funktion ausgewählt und für den Numbercruncher ausgeführt.
   *
   * @param operations die verfügbare Methamatische Funktionen
   */
  @Override
  public void crunch(String[] operations) {
    for(int i = 0; i < operations.length; i++) {
      String op = operations[i];
      System.out.println(op + " :");
      switch (op) {
        case "sum" -> run_sum();
        case "swirl" -> run_swirl();
        case "divide" -> run_divide();
        case "subtract" -> run_subtract();
        case "average" -> run_average();
        default -> System.out.println("Die operation ist nicht definiert");
      }
    }
  }

  public abstract float[] getNumbers();

  public abstract void run_average();

  public abstract void run_subtract();

  public abstract void run_divide();

  public abstract void run_swirl();

  public abstract void run_sum();
}
