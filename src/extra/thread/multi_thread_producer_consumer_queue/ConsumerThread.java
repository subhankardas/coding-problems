package extra.thread.multi_thread_producer_consumer_queue;

public class ConsumerThread implements Runnable {

	private FruitsQueue queue;

	public ConsumerThread(FruitsQueue queue) {
		this.queue = queue;
		new Thread(this, "Consumer").start();
	}

	@Override
	public void run() {
		try {
			// Run until consumer can consume i.e queue has fruits
			while (queue.canConsume()) {
				String fruit = queue.pop();
				System.out.println("Consume: " + fruit + "         Queue: " + queue);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted.");
		}
	}

}
