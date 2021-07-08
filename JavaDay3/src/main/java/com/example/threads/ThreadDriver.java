package com.example.threads;

public class ThreadDriver {
	
	public static void main(String[] args) {
		//You can create a thread in java with this
		Thread th = new Thread();
		
		//You can also get the currently running thread with this
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());
		
		try {
			mainThread.sleep(3000);
			System.out.println(mainThread.getPriority());
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		//To create a instance of my thread
		MyThread th1 = new MyThread();
		th1.setName("First Thread");
		
		//To create a thread with myrunnable
		MyRunnable r1 = new MyRunnable();
		
		Thread th2 = new Thread(r1);
		th2.setName("Thread Two");
		
		th1.start();
		th2.start();
		
		for(int i=0; i<200; i++) {
			System.out.println(Thread.currentThread().getName());
		}
	}
	
}
