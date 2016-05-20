/**
 *
 */
package bergamo.bruno;

import javax.management.NotificationBroadcasterSupport;

/**
 * @author brunobergamo
 *
 */
public class GenericJMXMonitor extends NotificationBroadcasterSupport implements GenericJMXMonitorMBean
{

    private static QueueI fila = new GenericQueue();

    @Override
    public int getQueueSize()
    {
        return fila.getValue();
    }

    @Override
    public int setNewAmount(int amount)
    {
        fila.setAmount(amount);
        return fila.getValue();
    }

}
