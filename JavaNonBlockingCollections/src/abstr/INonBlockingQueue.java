package abstr;

public interface INonBlockingQueue<E> {

	/**
	 * Add an element to the rear of the queue.
	 * Throws an IllegalStateException instance if queue is full capacity
	 * @param element
	 * @throws IllegalStateException
	 */
	void add(E element) throws IllegalStateException;
	
	/**
	 * Return the element at the front of the queue without applying any modification
	 *
	 */
	E front();
	
	/**
	 * Pop the front element from the queue
	 * Throws an IllegalStateException instance if queue is empty
	 * 
	 */
	E popFront() throws IllegalStateException;
	
	/**
	 * Return queue size
	 */
	int size();
	
	/**
	 * Return the number of elements can be added to the queue without
	 * throwing IllegalStateException instance
	 */
	int remainingCapacity();
	
}
