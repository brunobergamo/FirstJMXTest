package bergamo.bruno;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * This class implement a generic Queue
 *
 * @author brunobergamo
 *
 */
public class GenericQueue implements QueueI
{

    static AtomicInteger integers = new AtomicInteger();

    public static int getValueOut()
    {
        return integers.get();
    }

    @Override
    public int getValue()
    {
        return integers.get();
    }

    @Override
    public void insert(int pValue)
    {
        integers.addAndGet(pValue);
    }

    @Override
    public void remove(int pValue)
    {
        integers.addAndGet(-pValue);
    }

    @Override
    public void setAmount(int pValue)
    {
        integers.set(pValue);

    }
}
