package lab5;

import java.util.ArrayList;
import java.util.List;

public class Fifo {
	
	List<String> buffer = new ArrayList<>(10);

	public synchronized void put(String string) throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println("thread " + id + " put");
		while (buffer.size() >= 10) {
			wait();
		}
		buffer.add(string);	
		notifyAll();
	}
	
	public synchronized String get() throws InterruptedException {
		long id = Thread.currentThread().getId();
		System.out.println("thread " + id + " get");
		while (buffer.isEmpty()) {
			wait();
		}
		String str = buffer.remove(0);
		notifyAll();
		return str;
	}
}
