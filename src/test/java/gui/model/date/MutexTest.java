package gui.model.date;

import org.junit.Test;

import static org.junit.Assert.*;

public class MutexTest {

    @Test
    public void create01() {
        Mutex mutex = Mutex.create(null);
        assertNull(mutex);
    }

    @Test
    public void create02() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 2 0x9346756");
        assertNotNull(mutex);
    }

    @Test
    public void create03() {
        Mutex mutex = Mutex.create("(MUTBLOCK) 2");
        assertNotNull(mutex);
    }

    @Test
    public void getAddress() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 2 0x9346756");
        assertEquals(mutex.address.get(), mutex.getAddress());
    }

    @Test
    public void getThreadId() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 2 0x9346756");
        assertEquals(mutex.threadId.get(), mutex.getThreadId());
    }

    @Test
    public void getQueue() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 2 0x9346756");
        assertEquals(mutex.queue.get(), mutex.getQueue());
    }

    @Test
    public void setQueue() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 2 0x9346756");
        mutex.setQueue("1");
        assertEquals("1", mutex.getQueue());
    }

    @Test
    public void getStatus() {
        Mutex mutex = Mutex.create("(MUTACQUIRE) 2 0x9346756");
        assertEquals(mutex.status, mutex.getStatus());
    }
}