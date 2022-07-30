package ch06_CompletableFuture;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AppExecutors {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread " + Thread.currentThread().getName());
            }
        });

        // ==
        executorService.submit(() -> {
            System.out.println("Thread " + Thread.currentThread().getName());
        });

        executorService.shutdown(); // 명시적으로 종료 필요, graceful shutdown (다 돌아간 후 shutdown)
        executorService.shutdownNow();  // 스레드 종료와 상관없이 shutdown



        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        executorService2.submit(getRunnable("Hello1"));
        executorService2.submit(getRunnable("Hello2"));
        executorService2.submit(getRunnable("Hello3"));
        executorService2.submit(getRunnable("Hello4"));

        executorService2.shutdown();



        ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
        executorService3.schedule(getRunnable("Hello"), 3, TimeUnit.SECONDS);  //3초 후에 실행
        executorService3.scheduleAtFixedRate(getRunnable("Hello"), 1, 2, TimeUnit.SECONDS);  // 1초 기다렸다가 2초에 한번

        executorService3.shutdown();
    }

    private static Runnable getRunnable(String message) {
        return () -> System.out.println(message + Thread.currentThread().getName());
    }
}
