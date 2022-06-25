import java.util.function.IntPredicate;

/**
 * Ein Interface, der das Interface MyFunction mit zwei Default-Methoden erweitert.
 * 
 * @author Monzr Hajy Omar und Mouayad Haji Omar
 * 
 * @version 1.0
 */
@FunctionalInterface
public interface FInterface extends MyFunction  
{   
    /**
     * Eine Default-Methode, die ein Integer-Wert mit den eingegebenen IntPredicate testet und dann entweder die an die apply-Methode weiterleiten oder null zurückgeben.
     *
     *@param predicate zum Eingeben von predicaten
     */
    default MyFunction conditionateInput(IntPredicate predicate){ 
        /*if(predicate.test(num) == true){
            return (i) -> apply(i);
        }else{
            return (i) -> 0;
        }*/
        return number -> (predicate.test(number) ? this.apply(number) : 0);
    }
    
    /**
     * Eine Default-Methode, die das Ergebnis von einem Integer-Wert mit den eingegebenen IntPredicate testet und dann entweder das Ergebnis der apply-Methode oder null zurückgeben.
     *
     *@param predicate zum Eingeben von predicaten
     */
    default MyFunction conditionateOutput(IntPredicate predicate){ 
        /*if(predicate.test(apply(num)) == true){
            return (i) -> apply(i);
        }else{
            return (i) -> 0;
        }*/
        return number -> (predicate.test(apply(number)) ? this.apply(number) : 0);
    }
}
