package lab5;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {

	private Fifo fifo;
	private String name;
	private long timeout;
	
	

	public Consumer(String name, Fifo fifo, long timeout) {
		this.fifo = fifo;
		this.name = name;
		this.timeout = timeout;
	}



	@Override
	public void run() {
		while (true) {
			try {
				String readString = fifo.get();
				long time = System.currentTimeMillis() % 100_000;
				System.out.format("consumed\t%s\t%s\t%d%n", name, readString, time);
				TimeUnit.MILLISECONDS.sleep(timeout);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
