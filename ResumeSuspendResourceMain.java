public class ResumeSuspendResourceMain {
    public static void main(String[] args) {
        System.out.println("Main function starts");

      ResumeSuspendResource resumeSuspendResource = new ResumeSuspendResource();

      Thread th1 = new Thread(()->{
        System.out.println("Thread 1 calls produce method");
        resumeSuspendResource.produce();
      });
      Thread th2 = new Thread(()->{
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread 2 calls produce method");
        resumeSuspendResource.produce();
      });
      th1.start();
      th2.start();


      try{
        Thread.sleep(3000);
      }
      catch(Exception e){
        e.printStackTrace();
      }

      System.out.println("Suspending Thread 1");

      th1.suspend();
      

        try{
            Thread.sleep(3000);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        System.out.println("Resuming Thread 1");
        th1.resume();

        System.out.println("Main function ends");


    }
}
