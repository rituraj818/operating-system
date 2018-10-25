package operatingsystem;
import java.util.Scanner;

public class ProducerConsumer{
        static int s=1;
        static int full=0;
        static int emp=5;
        static int wait(int s)
        {
            s=s-1;
            return s;
        }
        
        static int signal(int s)
        {
            s=s+1;
            return s;
        }
        
        
        static void produce()
        {
            s=wait(s);
            full=signal(full);
            emp=wait(emp);
            System.out.println("Producer is producing....");
            s=signal(s);
        }
        
        static void consume()
        {
            s=signal(s);
            full=wait(full);
            emp=signal(emp);
            System.out.println("Consumer is consuming....");
            s=wait(s);
        }
     public static void main(String []args){
        
        Scanner sc=new Scanner(System.in);
        
        
        
        while(true)
        {
            System.out.println("---------------Producer-Consumer-Problem------------");
            System.out.println("1. Produce");
            System.out.println("2. Consume");
            System.out.println("3. Exit");
            int ch;
            ch=sc.nextInt();
            switch(ch)
            {
                case 1:
                    if(s==1 && emp!=0)
                        produce();
                    else
                        System.out.println("Producer waiting...!!");
                    break;
                case 2:
                    if(s==1 && full!=0)
                        consume();
                    else
                        System.out.println("Consumer waiting...!!");
                    break;    
                case 3:
                    System.exit(0);
                
                
            }
        }   
     }
}