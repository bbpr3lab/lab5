package lab5;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable {

	private String message;
	private Fifo fifo;
	private long timeout;
	public Producer(String string, Fifo fifo, long timeout) {
		this.message = string;
		this.fifo = fifo;
		this.timeout = timeout;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void go() throws InterruptedException {
		// TODO Auto-generated method stub
		int szam = 0;
		while (true) {
			String string = String.format("%s\t%d", message, szam++);
			fifo.put(string);
			long ido = System.currentTimeMillis() % 100_000;
			System.out.println("produced\t" + string + "\t" + ido);
			TimeUnit.MILLISECONDS.sleep(timeout);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			go();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
