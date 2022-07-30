package ch06_CompletableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AppExceptionHanding {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        boolean throwError = true;

        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            if (throwError) {
                throw new IllegalArgumentException();
            }

            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        }).exceptionally(ex -> {
            System.out.println(ex);
            return "Error!";
        });

        // exceptions, 정상적인 종료 모두 실행 (handle)
        CompletableFuture<String> hello1 = CompletableFuture.supplyAsync(() -> {
                    if (throwError) {
                        throw new IllegalArgumentException();
                    }

                    System.out.println("Hello " + Thread.currentThread().getName());
                    return "Hello";
        }).handle((result, ex) -> {
            if (ex != null) {
                System.out.println(ex);
                return "ERROR!";
            }
            return result;
        });

        System.out.println(hello.get());
    }
}
