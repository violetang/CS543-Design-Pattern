package PoolPattern;

/**
 * ObjectPoll class implements ObjectPool_IF to create a pool with reusable
 * object
 *
 * @Group: 7
 */
public class ObjectPool implements ObjectPool_IF {

    //attributes field
    private static ObjectPool poolInstance;
    private Object lockObject = new Object();
    private int size; // the size of objects that are actual avilable for reusing
    private int maxInstances;//
    private int instanceCount;//
    private ObjectCreation_IF c;
    private Object[] pool;// the array contains the objects that can be reused

    /**
     * Constructor to create a object pool
     * @param c -- the object that the pool will manage
     * @param capacity -- the number of currently unused objects that this pool
     * may contain at once
     * @param max -- the maximum number of instances that the pool should allow
     * to exist at one time
     */
    public ObjectPool(ObjectCreation_IF c, int capacity, int max) {
        this.c = c;
        this.size = 0;
        this.maxInstances = max;
        pool = new Object[capacity];
    }

    /**
     * getPoolInstance method to get an Instance of ObjectPool
     */
    public static ObjectPool getPoolInstance(ObjectCreation_IF c,
            int capacity, int max) {
        poolInstance = new ObjectPool(c, capacity, max);
        return poolInstance;
    }

    /**
     * getSize method to get the number of objects in the pool
     * @return size
     */
    @Override
    public int getSize() {
        return this.size;
    }

    /**
     * getCapacity method to return the maximum number of object that may be in
     * the pool awaiting reuse
     * @return pool.length
     */
    @Override
    public int getCapacity() {
        return pool.length;
    }

    /**
     * getInstanceCount to get the number of objects that currently exist
     * @return instanceCount
     */
    public int getInstanceCount() {
        return this.instanceCount;
    }

    /**
     * getMaxInstances to return the maximum number of objects that the pool
     * will allow to exist at one time
     * @return maxInstances
     */
    public int getMaxInstances() {
        return maxInstances;
    }

    /**
     * setCapacity method to set the maximum number of objects that may be in
     * the pool awaiting reuse
     * @param c -- the capacity
     */
    @Override
    public void setCapacity(int c) {
        if (c <= 0) {
            String msg = "Capacity must be greater than zero";
            throw new IllegalArgumentException(msg);
        }// if capacity is no greater than 0, throw exception
        synchronized (lockObject) {
            Object[] newPool = new Object[c];
            System.arraycopy(pool, 0, newPool, 0, c);
            pool = newPool;
        }//synchronized lockObject to check if can reset the pool
    }

    /**
     * getObject method to get an object from the pool
     * @return an object from the pool if there are available reused objects in
     * the pool, return the object on top else if the number of currently
     * existing objects is not reach the maximum number of objects that are
     * allowed to exist at one time, create an object and return it else return
     * null
     */
    @Override
    public Object getObject() {
        synchronized (lockObject) {
            if (size > 0) {
                return removeObject();
            } else if (getInstanceCount() < getMaxInstances()) {
                return createObject();
            } else {
                return null;
            }
        }
    }

    /**
     * waitForObject method to return an object from the pool
     * @return an object from the pool
     * @throws InterruptedException the difference between this method and
     * getObject method is that, if the number of objects exceeds the
     * maxInstances, this method will wait until an object becomes available for
     * reuse
     */
    @Override
    public Object waitForObject() throws InterruptedException {
        synchronized (lockObject) {
            if (size > 0) {
                return removeObject();
            } else if (getInstanceCount() < getMaxInstances()) {
                return createObject();
            } else {
                do {
                    wait();
                } while (size <= 0);
                return removeObject();
            }
        }
    }

    /**
     * removeObject to remove an object for the pool and return it
     * @return this object
     */
    private Object removeObject() {
        size--;
        return pool[size];
    }

    /**
     * release an object to the poll for reuse
     * @param o - the object to release
     * if the size of available reused objects is not reach the capacity of the 
     * pool, release the object to pool, notify a waiting thread that we have 
     * put an object in the pool
     */
    @Override
    public void release(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
        synchronized (lockObject) {
            if (getSize() < getCapacity()) {
                pool[size] = o; 
                size++;
                lockObject.notify();
            }
        }//synchronized 
    }
    /**
     * createObject method to create an object and increase instanceCount
     * @return new object created by ObjectCreation
     */
    private Object createObject() {
        Object newObject = c.create();
        instanceCount++;
        return newObject;
    }
}
