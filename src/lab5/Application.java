package lab5;


public class Application {
	
	static long randomLongBetween100and2000() {
		return (long) (100 + (Math.random() % 1900));
	}

	public static void main(String[] args) throws InterruptedException {
		Fifo fifo = new Fifo();
		Thread p1 = new Thread(new Producer("producer 1", fifo, randomLongBetween100and2000()));
		Thread p2 = new Thread(new Producer("producer 2", fifo, randomLongBetween100and2000()));
		Thread p3 = new Thread(new Producer("producer 3", fifo, randomLongBetween100and2000()));
		Thread c1 = new Thread(new Consumer("consumer 1", fifo, randomLongBetween100and2000()));
		Thread c2 = new Thread(new Consumer("consumer 2", fifo, randomLongBetween100and2000()));
		Thread c3 = new Thread(new Consumer("consumer 3", fifo, randomLongBetween100and2000()));
		Thread c4 = new Thread(new Consumer("consumer 4", fifo, randomLongBetween100and2000()));
		p1.start();
		p2.start();
		p3.start();
		c1.start();
		c2.start();
		c3.start();
		c4.start();
	}
}
