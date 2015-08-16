package test;

import static org.junit.Assert.assertTrue;

import impl.LinkedListNonBlockingQueueImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import abstr.INonBlockingQueue;

class QueueElementAdder<T> implements Runnable {

	public QueueElementAdder(T e, INonBlockingQueue<T> queue) {
		m_element = e;
		m_queue = queue;
	}

	@Override
	public void run() {
		try {
			m_queue.add(m_element);
		}
		catch(Exception e) {
			assertTrue(e.getClass() == IllegalStateException.class && 
					m_queue.remainingCapacity() == 0) ;
		}
	}

	private T m_element;
	private INonBlockingQueue<T> m_queue;
}

class QueueElementPopper<T> implements Runnable {

	public QueueElementPopper(INonBlockingQueue<T> queue) {
		m_queue = queue;
	}

	@Override
	public void run() {
		try {
			m_queue.popFront();
		}
		catch(Exception e) {
			assertTrue(e.getClass() == IllegalStateException.class && 
					m_queue.size() == 0) ;
		}
	}

	private INonBlockingQueue<T> m_queue;
}

public class NonBlockingQueueMultiThreadTest {

	private static final int QUEUE_CAPACITY = 6;
	private static final int NB_THREADS = 3;

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
		testAddElementsInMultiThreads();
		testPopElementsInMultiThread();
	}
	
	private void testAddElementsInMultiThreads() {
		ExecutorService queueElementAdderExecutor = Executors.newFixedThreadPool(NB_THREADS);
		for(int i = 0; i < 2 * QUEUE_CAPACITY; i++) {
			Runnable adder = new QueueElementAdder<Integer>(i, m_queue);
			queueElementAdderExecutor.execute(adder);
		}
		
		//Await tasks' termination
		try {
			queueElementAdderExecutor.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void testPopElementsInMultiThread() {
		ExecutorService queueElementAdderExecutor = Executors.newFixedThreadPool(NB_THREADS);
		for(int i = 0; i < 2 * QUEUE_CAPACITY; i++) {
			Runnable popper = new QueueElementPopper<Integer>(m_queue);
			queueElementAdderExecutor.execute(popper);
		}
		
		//Await tasks' termination
		try {
			queueElementAdderExecutor.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
