package Document.Codegym.Multithread.Runnable;

public class Main extends Thread {
    public void run() {
        System.out.println("Hello World in thread");
    }

    public static void main(String[] args) {
        Main thread = new Main();
        thread.start();
        System.out.println("Hello World in main");
    }
}
