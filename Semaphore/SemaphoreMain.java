public class SemaphoreMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");
        SharedResource semaphoreResource = new SharedResource();
        Thread thread1 = new Thread(()-> {
            semaphoreResource.producer();
            System.out.println("Thread 1 completed");
        });

        Thread thread2 = new Thread(()-> {
            semaphoreResource.producer();
            System.out.println("Thread 2 completed");
        });

        Thread thread3 = new Thread(()-> {
            semaphoreResource.producer();
            System.out.println("Thread 3 completed");
        });

        Thread thread4 = new Thread(()-> {
            semaphoreResource.producer();
            System.out.println("Thread 4 completed");
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        System.out.println("Main function ends");
    }
}