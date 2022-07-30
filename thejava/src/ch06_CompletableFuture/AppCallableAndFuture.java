package ch06_CompletableFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class AppCallableAndFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

//         Callable<String> hello = new Callable<String>() {
//                @Override
//                public String call() throws Exception {
//                    return null;
//                }
//         };

        // -> 람다
        Callable<String> hello = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Future<String> helloFuture = executorService.submit(hello);
        System.out.println(helloFuture.isDone());
        System.out.println("Started!");

        // 위에 까지는 쭉 실행
        // helloFuture .get(); // 결과값을 가져올 때 까지 기다림 (블로킹 콜)

        helloFuture.cancel(true);  // 현재 진행중인 작업을 interrupt 하고 중지
        helloFuture.cancel(false);  // 현재 진행중인 작업을 기다림 (get()해서 가져오지 못함)

        System.out.println("End!");
        executorService.shutdown();



        ExecutorService executorService1 = Executors.newSingleThreadExecutor();

        Callable<String> hello1 = () -> {
            Thread.sleep(2000L);
            return "Hello";
        };

        Callable<String> java = () -> {
            Thread.sleep(3000L);
            return "java";
        };
        Callable<String> kim = () -> {
            Thread.sleep(1000L);
            return "kim";
        };

        List<Future<String>> futures = executorService1.invokeAll(Arrays.asList(hello1, java, kim));
        for (Future<String> f : futures) {
            System.out.println(f.get());
        }

        String s = executorService1.invokeAny(Arrays.asList(hello1, java, kim));
        System.out.println(s);

        executorService1.shutdown();
    }
}
