package Posta;

class Sender implements Runnable {
    private final String name;
    private final PostOffice postOffice;

    public Sender(String name, PostOffice postOffice) {
        this.name = name;
        this.postOffice = postOffice;
    }

    @Override
    public void run() {
        try {
            postOffice.acceptItem(name);
        } catch (InterruptedException e) {
            System.out.println(name + " не зміг відправити лист/посилку через помилку.");
        }
    }
}
