/**
 *
 */
package bergamo.bruno;

/**
 * @author brunobergamo
 *
 */
public interface QueueI
{

    int getValue();

    void insert(int pValue);

    void remove(int pValue);

    void setAmount(int pValue);

}
