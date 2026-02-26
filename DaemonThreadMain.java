public class DaemonThreadMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");
        ResumeSuspendResource resumeSuspendResource = new ResumeSuspendResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 started");
            resumeSuspendResource.produce();
        });

        thread1.setDaemon(true);
        thread1.start();



        System.out.println("Main function ends");
    }
}