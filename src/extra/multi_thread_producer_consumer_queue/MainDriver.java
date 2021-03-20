package extra.multi_thread_producer_consumer_queue;

/**
 * Classic Producer-Consumer Problem : Let's say we have a list of fruits, so
 * when the producer has finished producing the first fruit and added it to the
 * queue then the consumer should be able to remove/consume that from the queue.
 * So when the queue is empty then the consumer should not able to consume from
 * the queue, in the same way when the queue is full producer should not able to
 * add more to the queue.
 * 
 * Requirement: Two threads are working and sharing the same shared queue, how
 * can we implement this effectively in a multi-threaded environment?
 */
public class MainDriver {

	public static void main(String[] args) {
		FruitsQueue queue = new FruitsQueue(2);

		new ProducerThread(queue);
		new ConsumerThread(queue);
	}

}
