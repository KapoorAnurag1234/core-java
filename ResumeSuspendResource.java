public class ResumeSuspendResource {
    boolean isAvailable = false;
   
    public synchronized void produce(){
        System.out.println("Lock Acquired");

        isAvailable = true;

        try{
            Thread.sleep(8000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Lock Released");
    }

}
