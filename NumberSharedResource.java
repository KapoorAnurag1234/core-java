public class NumberSharedResource {
    
    private int number;

    NumberSharedResource() {
        this.number = 1;
    }
    public synchronized void printOdd() throws InterruptedException {
        // System.out.println("Inside printOdd for number: " + number);
        while (number % 2 == 0) {
            wait();
        }
        System.out.println("Odd: " + number);
        number++;
        notify();
    }

    public synchronized void printEven() throws InterruptedException {
        // System.out.println("Inside printEven for number: " + number);
        while (number % 2 != 0) {
            wait();
        }
        System.out.println("Even: " + number);
        number++;
        notify();
    }

    
}
