class H_6Class implements Runnable
{
	public void run()
	{
		for(int i=1;i<=30;i++)
		{
			System.out.println(Thread.currentThread().getName()+" "+i);
			if(i%5==0)
			{
				Thread.yield();
			}
		}
	}
}

public class H_6Yield 
{
	public static void main(String[] args)
	{
		Thread F1=new Thread(new H_6Class());
		Thread F2=new Thread(new H_6Class());
//		H_6Class F=new H_6Class();
//		Thread F1=new Thread(F);
//		Thread F2=new Thread(F);
		F1.setName("线程一");
		F2.setName("第二个线程");
		F1.start();
		F2.start();
	}
}
