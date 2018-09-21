class H_41Class implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("1线程： "+i);
		}
	}
}

class H_42Class implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("第2个线程正在运行： "+i);
		}
	}
}

public class H_4PriorityI 
{
	public static void main(String[] args)
	{
		Thread D1=new Thread(new H_41Class());
		Thread D2=new Thread(new H_42Class());			
		//线程默认级别为5
		D2.setPriority(Thread.NORM_PRIORITY+3);			
		//数字越大优先级越高,但非绝对
		D1.start();
		D2.start();
	}
}
