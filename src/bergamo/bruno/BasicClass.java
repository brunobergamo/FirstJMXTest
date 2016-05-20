package bergamo.bruno;

import java.lang.management.ManagementFactory;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.management.*;

public class BasicClass
{

    private static void initializeMBean()
    {
        final MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        ObjectName name;
        try
        {
            name = new ObjectName("bergamo.bruno:type=GenericJMXMonitor");
            final GenericJMXMonitor mbean = new GenericJMXMonitor();
            mbs.registerMBean(mbean, name);
        }
        catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException
                        | NotCompliantMBeanException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void initializeThreads()
    {
        do
        {
            final ExecutorService executor = Executors.newFixedThreadPool(10);
            for (int i = 0; i < 10; i++)
            {
                final Runnable worker = new Worker(i);
                executor.execute(worker);
            }
            executor.shutdown();
            while (!executor.isTerminated())
            {
            }
            System.out.println("Finished all threads");
        } while (true);
    }

    public static void main(String[] args)
    {
        initializeMBean();

        initializeThreads();

        waitForeverAndEver();
    }

    private static void waitForeverAndEver()
    {
        try
        {
            Thread.sleep(Long.MAX_VALUE);
        }
        catch (final InterruptedException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
