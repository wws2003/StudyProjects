package impl;

import java.util.concurrent.atomic.AtomicReference;

import abstr.INonBlockingQueue;

public class LinkedListNonBlockingQueueImpl<E> implements INonBlockingQueue<E> {

	public LinkedListNonBlockingQueueImpl(int capacity) {
		m_capacity = capacity;
		m_headRef = new AtomicReference<Node<E>>(null);
	}

	@Override
	public void add(E element) throws IllegalStateException {
		Node<E> oldHead = null;
		Node<E> newHead = null;

		do {
			oldHead = m_headRef.get();

			//Throw exception if full capacity
			if(oldHead != null && oldHead.m_rank >= m_capacity) {
				throw new IllegalStateException("Queue has been full");
			}

			newHead = new Node<E>(element,
					oldHead,
					oldHead == null ? 1 : oldHead.m_rank + 1);

		}
		while(!m_headRef.compareAndSet(oldHead, newHead));
	}

	@Override
	public E front() {
		Node<E> head = m_headRef.get();
		return head == null ? null : head.m_item;
	}

	@Override
	public E popFront() throws IllegalStateException {
		Node<E> oldHead = null;
		Node<E> newHead = null;

		do {
			oldHead = m_headRef.get();

			//Throw exception if empty
			if(oldHead == null) {
				throw new IllegalStateException("Queue has been empty");
			}

			newHead = oldHead.m_next;
		}
		while(!m_headRef.compareAndSet(oldHead, newHead));
		
		return oldHead.m_item;
	}

	@Override
	public int size() {
		Node<E> head = m_headRef.get();
		return head == null ? 0 : head.m_rank;
	}

	@Override
	public int remainingCapacity() {
		return m_capacity - size();
	}

	private int m_capacity;
	private AtomicReference<Node<E>> m_headRef;

	static class Node<E> {
		final E m_item;
		Node<E> m_next;
		final int m_rank;

		public Node(E item, Node<E> next, int rank) {
			m_item = item;
			m_next = next;
			m_rank = rank;
		}
	}
}
