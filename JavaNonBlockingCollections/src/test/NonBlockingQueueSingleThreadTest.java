package test;

import static org.junit.Assert.*;
import impl.LinkedListNonBlockingQueueImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import abstr.INonBlockingQueue;

public class NonBlockingQueueSingleThreadTest {

	private static final int QUEUE_CAPACITY = 5;

	private INonBlockingQueue<Integer> m_queue = null;

	@Before
	public void setUp() throws Exception {
		m_queue = new LinkedListNonBlockingQueueImpl<Integer>(QUEUE_CAPACITY);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		testAddInCapacity(m_queue);
		testPopNonEmpty(m_queue);
		testPopEmpty(m_queue);
		testAddOutCapacity(m_queue);
	}

	private void testAddInCapacity(INonBlockingQueue<Integer> queue) {
		for(int i = 0; i < QUEUE_CAPACITY; i++) {
			queue.add(i);
			assertEquals(queue.size(), i + 1);
			assertEquals(queue.remainingCapacity(), QUEUE_CAPACITY - (i + 1));
		}
	}

	private void testPopNonEmpty(INonBlockingQueue<Integer> queue) {
		while(queue.size() > 0) {
			int e = queue.popFront();
			assertEquals(e, queue.size()); //Regarding the flow of adding elements to queue
		}
		assertTrue(queue.size() == 0);
	}

	private void testPopEmpty(INonBlockingQueue<Integer> queue) {
		try {
			while(true) {
				queue.popFront();
			}	
		}
		catch(Exception e) {
			assertEquals(e.getClass(), IllegalStateException.class);
			assertEquals(queue.size(), 0);
		}
	}

	private void testAddOutCapacity(INonBlockingQueue<Integer> queue) {
		try {
			int i = queue.size();
			while(true) {
				queue.add(i);
				assertEquals(queue.size(), i + 1);
				assertEquals(queue.remainingCapacity(), QUEUE_CAPACITY - (i + 1));
				i++;
			}
		}
		catch(Exception e) {
			assertEquals(e.getClass(), IllegalStateException.class);
			assertEquals(queue.size(), QUEUE_CAPACITY);
			assertEquals(queue.remainingCapacity(), 0);
		}
	}
}
