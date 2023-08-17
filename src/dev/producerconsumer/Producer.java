package dev.producerconsumer;


import java.util.List;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private int id;
    private BlockingQueue<String> queue;
    private List<String> commands;

    public Producer(int id, BlockingQueue<String> queue, List<String> commands) {
        this.id = id;
        this.queue = queue;
        this.commands = commands;

    }

    @Override
    public void run() {

        Random random = new Random();

        for(String command: commands) {
            try {
                System.out.printf("Producer %d produced %s%n",
                        id, command);
                queue.put(command);
                Thread.sleep(random.nextInt(100));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            queue.put("Finished");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

