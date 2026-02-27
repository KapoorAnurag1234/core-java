public class MonitorLockExample {

public synchronized void task1() {
    try {
        System.out.println("inside task1");
        Thread.sleep(10000);
    }
    catch (Exception e) {
        // exception will come here
    }

    System.out.println("task1 finished");
}

public void task2(){
    System.out.println("inside task 2 before synchronized");
    synchronized(this){
        System.out.println("inside task2 synchronized");
    }
    System.out.println("task2 finished");
}

public void task3(){
    System.out.println("task3");
}

}