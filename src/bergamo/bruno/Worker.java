package bergamo.bruno;

public class Worker implements Runnable
{

    int i;

    public Worker(int pValue)
    {
        i = pValue;
    }

    @Override
    public void run()
    {
        try
        {
            Thread.sleep(5000 * i);
        }
        catch (final InterruptedException e)
        {
            e.printStackTrace();
        }

        final QueueI queue = new GenericQueue();
        if (i % 2 == 0)
        {
            queue.insert(i);
            queue.insert(i * 3);
        }
        else
        {
            queue.remove(i * 2);
        }
    }

    @Override
    public String toString()
    {
        return "THREAD BRUNO" + i;
    }
}
