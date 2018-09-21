class H_7Class implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("\t子线程： "+i);
		}
	}
}

public class H_7Join 
{
	public static void main(String[] args)
	{
		Thread G=new Thread(new H_7Class());
		G.start();
		try
		{
			G.join();		//阻塞时将当前线程暂停，直至调至join函数所对应的线程对应结束，才继续执行程序
		}catch(Exception e){}
		for(int i=0;i<15;i++)
		{
			System.out.println("主线程： "+i);
		}
	}

}
