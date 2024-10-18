package Posta;

import java.util.concurrent.TimeUnit;

class PostOffice {
    private final int workHours = 4; // Час роботи пошти в секундах
    private boolean open = true;

    public synchronized void acceptItem(String sender) throws InterruptedException {
        if (!open) {
            System.err.println("\t\tПошта закрита :( \n" + sender + " не зміг відправити посилку.");
            return;
        }
        System.out.println(sender + " приніс лист/посилку на пошту.");
        TimeUnit.SECONDS.sleep(2); // Працівник обробляє замовлення
        System.out.println("Працівник прийняв посилку від " + sender + " і відправив її ^_^");
    }

    public int getWorkHours() {
        return workHours;
    }

    public void closePostOffice() {
        open = false;
        System.err.println("\t\tПошта закрилася :(\n\tостався останній клієнт \nЗамовлення більше не приймаються.");
    }
}
