import java.util.concurrent.Semaphore;

public class BundedBuffer implements Buffer {
	private static final int BUFFER_SIZE = 5;
	private Object[] buffer;
	private int in, out;
	private Semaphore mutex;
	private Semaphore empty;
	private Semaphore full;

	public BundedBuffer() {
		in = 0;
		out = 0;
		buffer = new Object[BUFFER_SIZE];

		mutex = new Semaphore(1);
		empty = new Semaphore(BUFFER_SIZE);
		full = new Semaphore(0);

	}

	@Override
	public Object remove() throws InterruptedException {

		full.acquire();
		mutex.acquire();
		Object item = buffer[out];
		out = (out + 1) % BUFFER_SIZE;

		mutex.release();
		empty.release();
		return item;

	}

	@Override
	public void insert(Object item) throws InterruptedException {
		empty.acquire();
		mutex.acquire();

		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;

		mutex.release();
		full.release();

	}

}
