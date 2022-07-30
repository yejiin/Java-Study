package ch06_CompletableFuture;

public class AppThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());



//        Thread thread = new Thread(new Runnable() {
//				@Override
//				public void run() {
//						System.out.println("Thread: " + Thread.currentThread().getName());
//				}
//		});

        Thread thread = new Thread(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
        });  // 람다
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());



        Thread thread1 = new Thread(() -> {
            try {
                Thread.sleep(1000L);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: " + Thread.currentThread().getName());
        });  // 람다
        thread1.start();

        System.out.println("Hello: " + Thread.currentThread().getName());



        Thread thread2 = new Thread(() -> {
            while(true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000L);
                } catch(InterruptedException e) {
                    System.out.println("interrupted!");
                    return;
                }
            }

        });  // 람다
        thread2.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        Thread.sleep(3000L);
        thread2.interrupt();


        Thread thread3 = new Thread(() -> {
            while(true) {
                System.out.println("Thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(3000L);
                } catch(InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        });
        thread.start();

        System.out.println("Hello: " + Thread.currentThread().getName());
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread + " is finished");

    }

    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello: " + Thread.currentThread().getName());
        }
    }
}
