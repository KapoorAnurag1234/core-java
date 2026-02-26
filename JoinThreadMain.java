public class JoinThreadMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");
        ResumeSuspendResource resumeSuspendResource = new ResumeSuspendResource();

        Thread thread1 = new Thread(() -> {
            resumeSuspendResource.produce();
            System.out.println("Thread 1 completed");
        });

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main function ends");
        
    }
}
