package operatingsystem;
import java.util.*;

public class ProducerConsumerThread {
    public static void main(String[] args) {
        List<Integer> b=new ArrayList<>();
        Thread t1=new Thread(new Producer(b));
        Thread t2=new Thread(new Consumer(b));
        t1.start();
        t2.start();
        
    }
}

class Producer implements Runnable
{
    List<Integer> b=null;
    final int limit=5;
    int i=0;
    Producer(List<Integer> b)
    {
        this.b=b;
    }
    
    @Override
    public void run()
    {
        try{
            while(true)
                produce();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void produce() throws InterruptedException
    {
        synchronized(b)
                {
                 while(b.size()==limit)
                 {
                     System.out.println("Producer waiting..");
                     b.wait();
                 }
                    
                }
        synchronized(b)
        {
            i=i+1;
            b.add(i);
            Thread.sleep(1000);
            b.notify();
            System.out.println("Producer is producing...");
        }
    }
    
}