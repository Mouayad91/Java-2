import java.util.Arrays;

/**
 * Programm, um eine Mathematische Funktion für den Numbercruncher auszuführen.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 *
 * @version 1.0
 */
public class NumberCruncherAnonym extends NumberCruncher{

  private float arr[];
  private NumberCruncherTopLevel numberCruncherTopLevel;

  /**
   * Konstruktur, mit dem man das Array für den Numbercruncher erstellt.
   *
   * @param arr Array des Numbercrunchers
   */
  public NumberCruncherAnonym(float arr[]) {
    if (arr.length > 0) {
      this.arr = arr;
    } else {
      throw new IllegalArgumentException("Array muss nicht leer sein");
    }
  }

  /**
   * Methode gibt das Array zurück.
   *
   * @return arr Inhalte des Arrays
   */
  @Override
  public float[] getNumbers() {
    return arr;
  }

  /**
   * Methode erstellt ein Array mit der zuerst (this.arr) eingegebenen Werte, und führt Anonym mit dem, eine Mathematische Funktion aus.
   *
   */
  @Override
  public void run_average() {
    numberCruncherTopLevel = new NumberCruncherTopLevel(arr) {
      public void run_average() {
        float[] op_arr = MathematischeOperationen.average(arr);
        System.out.println(Arrays.toString(op_arr));
        arr = op_arr;

      }
    };
    numberCruncherTopLevel.run_average();
  }

  @Override
  public void run_subtract() {
    numberCruncherTopLevel = new NumberCruncherTopLevel(arr) {
      public void run_subtract() {
        float[] op_arr = MathematischeOperationen.substract(arr);
        System.out.println(Arrays.toString(op_arr));
        arr = op_arr;

      }
    };
    numberCruncherTopLevel.run_subtract();
  }

  @Override
  public void run_divide() {
    numberCruncherTopLevel = new NumberCruncherTopLevel(this.arr) {
      public void run_divide() {
        float[] op_arr = MathematischeOperationen.divide(arr);
        System.out.println(Arrays.toString(op_arr));
        arr = op_arr;

      }
    };
    numberCruncherTopLevel.run_divide();
  }

  @Override
  public void run_swirl() {
    numberCruncherTopLevel = new NumberCruncherTopLevel(arr) {
      public void run_swirl() {
        float[] op_arr = MathematischeOperationen.swirl(arr);
        System.out.println(Arrays.toString(op_arr));
        arr = op_arr;

      }
    };
    numberCruncherTopLevel.run_swirl();
  }

  @Override
  public void run_sum() {
    numberCruncherTopLevel = new NumberCruncherTopLevel(arr) {
      public void run_sum() {
        float[] op_arr = MathematischeOperationen.sum(arr);
        System.out.println(Arrays.toString(op_arr));
        arr = op_arr;

      }
    };
    numberCruncherTopLevel.run_sum();
  }
}
