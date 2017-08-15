package eda.exceptions;

/**
 *
 * @author edi
 */
public class ElementNotFoundException extends RuntimeException{
    
    public ElementNotFoundException(String collection) {
        super("La coleccion " + collection + " no contiene al elemento");
    }
}
