package ch06_CompletableFuture;

import java.util.concurrent.*;

public class AppCompletableFuture1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        Future<String> future = executorService.submit(() -> "hello");


        CompletableFuture<String> future1 = new CompletableFuture<>();
        future1.complete("kim");
        System.out.println(future1.get());

        CompletableFuture<String> future2 = CompletableFuture.completedFuture("kim");
        System.out.println(future2.get());


        // 리턴 값이 없는 경우 (runAsync)
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
        });
        future3.get();

        // 리턴 값이 있는 경우 (supplyAsync)
        CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });
        System.out.println(future4.get());

        // 콜백 추가 (thenApply() - 리턴 O)
        CompletableFuture<String> future5 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenApply(s -> {
            System.out.println(Thread.currentThread().getName());
            return s.toUpperCase();
        });

        // 콜백 추가 (thenAccept() - 리턴 X)
        CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenAccept(s -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(s.toUpperCase());
        });

        // 콜백 추가 (thenRun() - 파라미터 X)
        CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });


        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future8 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }, executorService1).thenRun(() -> {
            System.out.println(Thread.currentThread().getName());
        });

        executorService1.shutdown();;
    }
}
