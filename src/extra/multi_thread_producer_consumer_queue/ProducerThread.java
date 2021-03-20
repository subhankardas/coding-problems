package extra.multi_thread_producer_consumer_queue;

public class ProducerThread implements Runnable {

	private static String[] fruits = { "Apple", "Banana", "Mango", "Pear", "Orange", "Pineapple" };
	private FruitsQueue queue;
	private int idx;

	public ProducerThread(FruitsQueue queue) {
		this.queue = queue;
		idx = 0;
		new Thread(this, "Producer").start();
	}

	@Override
	public void run() {
		try {
			// Run until producer can produce i.e array has fruits
			while (idx != fruits.length) {
				// Produce only if queue has space
				if (queue.canProduce()) {
					String fruit = fruits[idx++];
					queue.push(fruit);
				}
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted.");
		}
	}

}
