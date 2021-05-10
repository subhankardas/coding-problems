package extra.thread.multi_thread_producer_consumer_queue;

import java.util.Vector;

public class FruitsQueue {

	private static Vector<String> queue;
	private static int CAPACITY;

	public FruitsQueue(int capacity) {
		queue = new Vector<String>(capacity);
		CAPACITY = capacity;
	}

	public synchronized boolean push(String fruit) {
		return queue.add(fruit);
	}

	public synchronized String pop() {
		return queue.remove(0);
	}

	public synchronized int size() {
		return queue.size();
	}

	public synchronized boolean isFull() {
		return queue.size() == CAPACITY;
	}

	public synchronized boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public synchronized String toString() {
		return queue.toString();
	}

	/**
	 * Determines if producer is allowed to produce more fruits based on which waits
	 * or notifies producer thread in context. Since this method is called from
	 * producer thread hence it waits/notifies in that context.
	 */
	public synchronized boolean canProduce() throws InterruptedException {
		// If queue is full, wait producer thread else notify it to produce more
		if (isFull()) {
			wait();
			return false;
		} else {
			notify();
			return true;
		}
	}

	/**
	 * Determines if consumer is allowed to consume more fruits based on which waits
	 * or notifies consumer thread in context. Since this method is called from
	 * consumer thread hence it waits/notifies in that context.
	 */
	public synchronized boolean canConsume() throws InterruptedException {
		// If queue is empty, wait consumer thread else notify it to consume more
		if (isEmpty()) {
			wait();
			return false;
		} else {
			notify();
			return true;
		}
	}

}
