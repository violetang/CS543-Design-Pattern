package PoolPattern;

/**
 * ObjectPool_IF interface
 * @Group: 7
 */
public interface ObjectPool_IF {
    public int getSize();
    public int getCapacity();
    public void setCapacity(int c);
    public Object getObject();
    public Object waitForObject() throws InterruptedException;
    public void release(Object o);
}
