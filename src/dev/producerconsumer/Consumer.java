package dev.producerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
    private int id;
    private BlockingQueue<String> queue;
    Random random = new Random();

    public Consumer(int id, BlockingQueue<String> queue) {
        this.id = id;
        this.queue = queue;
    }

    @Override
    public void run() {
        String command;
        try {
            while (!(command = queue.take()).equals("Finished")) {
                System.out.printf("Consumer %d consumed this command: %s %n",
                        id, command);


                if (command.equals("PrintAll")) SQLiteManagement.printAll();
                if (command.equals("DeleteAll")) SQLiteManagement.deleteAll();
                if(command.contains("Add")) {
                    User user = Parser.parseCommand(command);
                    SQLiteManagement.add(user.getUserId(), user.getUserGuid(), user.getUserName());
                }



                Thread.sleep(random.nextInt(100));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("All done! Finished found!");
    }
}
