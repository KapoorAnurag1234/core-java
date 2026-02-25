public class NumberSharedResourceMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");

        NumberSharedResource numberSharedResource = new NumberSharedResource();

        Thread oddThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    numberSharedResource.printOdd();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });         
        Thread evenThread = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++) {
                    numberSharedResource.printEven();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        oddThread.start();
        evenThread.start();
        System.out.println("Main function ends");
    }
}
