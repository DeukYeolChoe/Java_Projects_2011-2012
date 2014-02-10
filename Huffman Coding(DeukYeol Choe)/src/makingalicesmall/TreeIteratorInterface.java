/*
 * TreeIteratorInterface.java
 *
 * Created on May 21, 2007, 1:31 PM
 */

package makingalicesmall;
import java.util.*;
/**
 * @author Carranno
 */
public interface TreeIteratorInterface<T>
{
    public Iterator<T> getInOrderIterator();
}
