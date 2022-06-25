import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Programm, bearbeitet den Numbercruncher durch eine ausgewählte Mathematische Funktion und gibt die Ergebnisse des Arrays zurück.
 *
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 *
 * @version 1.0
 */


public class MathematischeOperationen {
  private static List<Float> floatList;

  /**
   * Mit dieser Methode wird die Mathematische Funktion Sum für den Numbercruncher bearbeitet.
   *
   * @param arr das eingegebne Array
   * @return arr das Array nach der Bearbeitung
   */
  public static float[] sum(float[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i+1] = arr[i] + arr[i+1];
    }
    return arr;
  }

  /**
   * Mit dieser Methode wird die Mathematische Funktion swirl für den Numbercruncher bearbeitet.
   *
   * @param arr das eingegebne Array
   * @return arr das Array nach der Bearbeitung
   */
  public static float[] swirl(float[] arr) {
    Random random = new Random();
    int random_Index = 0;
    int len = arr.length;
    for (int i = 0; i < arr.length; i++) {
      random_Index = random.nextInt(len);
      float random_Index_Wert = arr[random_Index];
      float aktuell_Index_Wert = arr[i];
      arr[random_Index] = aktuell_Index_Wert;
      arr[i] = random_Index_Wert;
    }
    return arr;
  }

  /**
   * Mit dieser Methode wird die Mathematische Funktion divide für den Numbercruncher bearbeitet.
   *
   * @param arr das eingegebne Array
   * @return arr das Array nach der Bearbeitung
   */
  public static float[] divide(float[] arr) {
    float[] arr_sort = new float[arr.length];
    for(int i = 0; i < arr.length; i++) {
      arr_sort[i] = arr[i];
    }
    // arr_sort = arr; in der nächste zeile wird arr auch sortiert und das wollen wir nicht
    sort(arr_sort);
    float[] arr_max = get_Array_MaxWerte(arr_sort);
    float[] arr_min = get_Array_MinWerte(arr_sort);
    for(int i = 0; i < arr_max.length; i++) {
      for (int j = 0; j < arr.length; j++) {
        if(arr_max[i] == arr[j]) {
          arr[j] = arr[j] / arr_min[i];
          break;
        }
      }
    }
    return arr;
  }

  /**
   * Mit dieser Methode wird die Mathematische Funktion substract für den Numbercruncher bearbeitet.
   *
   * @param arr das eingegebne Array
   * @return arr das Array nach der Bearbeitung
   */
  public static float[] substract(float[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      arr[i+1] = arr[i] - arr[i+1];
    }
    return arr;
  }

  /**
   * Mit dieser Methode wird die Mathematische Funktion average für den Numbercruncher bearbeitet.
   *
   * @param arr das eingegebne Array
   * @return arr das Array nach der Bearbeitung
   */
  static float[] average(float[] arr) {
    int index_max_wert = get_Index_MaxWert(arr);
    float summe = 0;
    for (int i = 0; i < arr.length; i++) {
      summe += arr[i];
    }
    arr[index_max_wert] = summe / arr.length;
    return arr;
  }

  /**
   * Mthode gibt den Platz von der größten Zahl in meinem Array zurück.
   *
   * @param arr das eingegebne Array
   * @return index Platz der größten Zahl
   */
  private static int get_Index_MaxWert(float[] arr) {
    int index = 0;
    float max_wert = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if(max_wert < arr[i]) {
        max_wert = arr[i];
        index = i;
      }
    }
    return index;
  }

  /**
   * Mthode sortiert das eingegebene Array aufsteigend.
   *
   * @param arr das eingegebne Array
   * @return arr das Array nach Sortierung
   */
  private static float[] sort(float[] arr) {
    Arrays.sort(arr);
    return arr;
  }

  /**
   * Mit dieser Methode wird die Hälfte des eingegebenen Arrays absteigend sortiert.
   *
   * @param arr das eingegebne Array
   * @return new_arr das Array nach der Sortierung
   */
  private static float[] get_Array_MaxWerte(float[] arr) {

    float[] new_arr = new float[arr.length/2];
    for(int i = 0; i < new_arr.length ;i++) {
      new_arr[i] = arr[(arr.length - 1)-i];
    }

    return new_arr;
  }

  /**
   * Mit dieser Methode wird die Hälfte des eingegebenen Arrays aufsteigend sortiert.
   *
   * @param arr das eingegebne Array
   * @return new_arr das Array nach der Sortierung
   */
  private static float[] get_Array_MinWerte(float[] arr) {
    float[] new_arr = new float[arr.length/2];
    for(int i = 0; i < arr.length/2; i++) {
      new_arr[i] = arr[i];
    }
    return new_arr;
  }

  /**
   * Die Main Methode der Klasse, um das Programm auszuführen und zu testen.
   *
   * @param args
   */
  public static void main(String[] args) {
    float[] ar = {5.0f, 10.0f, 25.0f, 3.0f, 11.0f};
    float[] arr = {5.0f, 10.0f, 25.0f, 3.0f, 11.0f};
    float[] arr_ = substract(ar);
    //System.out.println(Arrays.toString(arr_));
    System.out.println(Arrays.toString(arr));
    //System.out.println(get_Index_MaxWert(arr));
    //System.out.println(get_Index_MinWert(arr));
    //float[] ama = get_Array_MaxWerte(arr);
    //float[] ami = get_Array_MinWerte(arr);
    //System.out.println("MAX MIN");
    //System.out.println(Arrays.toString(ama));
    //System.out.println(Arrays.toString(ami));
    //System.out.println("ENDE MAX MIN");
    float[] t = {5.0f, 10.0f, 25.0f, 3.0f, 11.0f};
    float[] arrd = divide(arr);
    System.out.println(Arrays.toString(arrd));
    float[] arr_avg = average(t);
    System.out.println(Arrays.toString(arr_avg));
    //arr = entferne_ArrayWerte(arr, 1);
    //System.out.println(Arrays.toString(arr));

    float[] arr2 = sum(arr);

    System.out.println(Arrays.toString(arr2));
    float[] arr3 = swirl(arr);
    System.out.println(Arrays.toString(arr3));
    sort(arr3);
    System.out.println(Arrays.toString(arr3));
    float[] arr4 = divide(arr3);
    System.out.println(Arrays.toString(arr4));
    String g = "sum,divide,sub";
    String[] arrs = g.split(",");
    System.out.println(Arrays.toString(arrs));

  }
}
