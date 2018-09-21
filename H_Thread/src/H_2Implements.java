//不继承类，而是改成了实现接口

class H_2Class implements Runnable
{		
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("子函数");
		}
	}
}

public class H_2Implements 
{
	public static void main(String[] args)
	{
		H_2Class B=new H_2Class();
		Thread b=new Thread(B);
		B.run();
		System.out.println();
		b.start();
		for(int i=0;i<10;i++)
		{
			System.out.println("主函数");
		}
	}
}
