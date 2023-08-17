import dev.producerconsumer.Consumer;
import dev.producerconsumer.Producer;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        List<String> commandsList = new ArrayList<>();
        commandsList.add("Add(1, 'a1', 'Robert')");
        commandsList.add("Add(2, 'a2', 'Robert')");
        commandsList.add("PrintAll");
        commandsList.add("Add(3, 'a3', 'Robert')");
        commandsList.add("DeleteAll");
        commandsList.add("Add(4, 'a4', 'Robert')");
        commandsList.add("PrintAll");

        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        Producer p1 = new Producer(1, queue, commandsList);
        Consumer c1 = new Consumer(1, queue);
        Consumer c2 = new Consumer(2, queue);

        ExecutorService service = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors());

        service.execute(p1);
        service.execute(c1);
        service.execute(c2);
        service.shutdown();
    }
}
