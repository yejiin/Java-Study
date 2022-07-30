package ch06_CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class AppCompletableFuture2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
            System.out.println("Hello " + Thread.currentThread().getName());
            return "Hello";
        });

        CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return "World";
        });

        // 의존
        CompletableFuture<String> future = hello.thenCompose(AppCompletableFuture2::getWord);
        System.out.println(future.get());

        // 의존 X
        CompletableFuture<String> future1 = hello.thenCombine(world, (h, w) -> h + " " + w);
        System.out.println(future1.get());

        // 여러 task 를 다 합쳐서 실행 (task 의 return type 이 다 다르므로 결과값은 무의미(null)
        CompletableFuture.allOf(hello, world)
                .thenAccept(System.out::println);


        // 결과 전체 호출
        List<CompletableFuture> futures = Arrays.asList(hello, world);
        CompletableFuture[] futuresArray = futures.toArray(new CompletableFuture[futures.size()]);
        CompletableFuture<List<Object>> results = CompletableFuture.allOf(futuresArray)
                .thenApply(v -> futures.stream()
                            .map(CompletableFuture::join)
                            .collect(Collectors.toList()));

        results.get().forEach(System.out::println);

        // 결과 아무거나 하나 호출
        CompletableFuture<Void> future2 = CompletableFuture.anyOf(hello, world).thenAccept(System.out::println);
        future2.get();
    }


    private static CompletableFuture<String> getWord(String message) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("World " + Thread.currentThread().getName());
            return message + " World";
        });
    }
}
