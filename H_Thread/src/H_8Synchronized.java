/*
 * synchronized 的作用是：让它管辖的代码部分，要么全部执行，要么全部不执行
 * synchronized 修饰函数不需要字符串，相当于默认是this，	public synchronized void run()
 */
class H_8Class implements Runnable
{
	public static int tickets=100;
	String H=new String("8");		//字符串随意定义，定义在函数上边
	public void run()
	{
		while(true)
		{
			synchronized(H)
			{		//既可以修饰代码块，又可以修饰函数
				if(tickets>0)
				{
					System.out.println(Thread.currentThread().getName()+"车站正在卖第"+(101-tickets)+"张车票");
					tickets--;
				}else
				{
					break;
				}
			}
		}
	}
}

public class H_8Synchronized 
{
	public static void main(String[] args)
	{
		H_8Class h=new H_8Class();
		Thread h1=new Thread(h);
		h1.setName("上海");
		h1.start();
		Thread h2=new Thread(h);
		h2.setName("北京");
		h2.start();
	}
}
