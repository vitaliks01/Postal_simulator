package Posta;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        PostOffice postOffice = new PostOffice();
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Відправники
        executor.execute(new Sender("Толя", postOffice));
        executor.execute(new Sender("Коля", postOffice));
        executor.execute(new Sender("Міша", postOffice));



        // Симуляція робочих годин пошти
        try {
            TimeUnit.SECONDS.sleep(postOffice.getWorkHours()); // Використовуємо геттер
        } catch (InterruptedException e) {
            System.out.println("Помилка під час роботи пошти.(");
        }

        postOffice.closePostOffice();
        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
