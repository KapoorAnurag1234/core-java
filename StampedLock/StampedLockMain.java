public class StampedLockMain {
    public static void main(String[] args){
        System.out.println("Main function starts");
        SharedResource sharedResource = new SharedResource();
        Thread th1 = new Thread(()-> {
            sharedResource.producer();
        });

        Thread th2 = new Thread(()-> {
            sharedResource.consumer();
        });

        th1.start();
        th2.start();

        System.out.println("Main function ends");
        

    }
}