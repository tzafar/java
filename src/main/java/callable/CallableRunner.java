package callable;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.Future;

public class CallableRunner {
    public static void main(String... args) throws Exception {

        List<Callable<Void>> callables = getCallables();

        ThreadPoolTaskExecutor executor = getExecutor();

        CompletionService<Void> completionService = new ExecutorCompletionService<>(executor);

        executeCallables(callables, completionService);

        int count = 0;

        while(count != callables.size()){
            Future<Void> future = completionService.take();
            if(future.isDone()){
                count++;
            }
        }

        System.out.println("Right after executing callables");
    }

    private static void executeCallables(List<Callable<Void>> callables, CompletionService<Void> completionService) {
        callables.forEach(completionService::submit);
    }

    private static ThreadPoolTaskExecutor getExecutor() {
        ThreadPoolTaskExecutor executor =  new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.initialize();
        return executor;
    }

    private static List<Callable<Void>> getCallables() {
        List<Callable<Void>> callables = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int rank = i;
            callables.add(
                    () -> {
                        Person person = new Person();
                        person.sayName("A", rank);
                        return null;
                    }
            );
        }
        return callables;
    }
}

class Person {
    public void sayName(String name, Integer rank) {
        System.out.println(String.format("my name is %s and my rank is %s and thread id is %s", name, rank, Thread.currentThread().getId()));
    }
}

