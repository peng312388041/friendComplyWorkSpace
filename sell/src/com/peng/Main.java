package com.peng;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// 定义5个生产者
		Thread producerThread1 = new Thread(new Producer());
		Thread producerThread3 = new Thread(new Producer());
		Thread producerThread2 = new Thread(new Producer());
		Thread producerThread5 = new Thread(new Producer());
		Thread producerThread4 = new Thread(new Producer());
		producerThread1.start();
		Thread.sleep(2000);
		producerThread2.start();
		Thread.sleep(2000);
		producerThread3.start();
		// producerThread4.start();
		// Thread.sleep(2000);
		// producerThread5.start();

		// 定义3个消费者
		Thread consumeThread1 = new Thread(new Consumer());
		Thread consumeThread2 = new Thread(new Consumer());
		Thread consumeThread3 = new Thread(new Consumer());
		Thread consumeThread4 = new Thread(new Consumer());
		Thread consumeThread5 = new Thread(new Consumer());

		consumeThread1.start();
		Thread.sleep(2000);
		consumeThread2.start();
		Thread.sleep(2000);
		consumeThread3.start();
		consumeThread4.start();
		consumeThread5.start();

	}

}
