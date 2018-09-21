class Goods
{
	private char[] vol=new char[8];
	private int num=0;
	
	public synchronized void production(char aa)
	{
		while(num==vol.length)
		{
			try
			{
				this.wait();
			}catch(Exception e) {}
		}
		this.notify();		//叫醒另一线程，是在当前线程处于就绪状态的前提下
		vol[num]=aa;
		num++;
		System.out.println("生产线程正在生产第"+num+"个产品，该产品是： "+aa);
	}
	
	public synchronized void consumption()
	{
		while(num==0)
		{
			try
			{
				this.wait();
			}catch(Exception e) {}
		}
		this.notify();
		char aa=vol[num-1];
		System.out.println("消费线程正在消费第"+num+"个产品，该产品是： "+aa);
		num--;
	}
}

class prod implements Runnable
{
	private Goods I=null;
	
	public prod(Goods I)
	{
		this.I=I;
	}
	
	public void run()
	{
		for(int i=0;i<26;i++)
		{
			char aa=(char)('A'+i);
			I.production(aa);
		}
	}
}

class cons implements Runnable
{
	private Goods I=null;
	
	public cons(Goods I)
	{
		this.I=I;
	}
	
	public void run()
	{
		for(int i=0;i<26;i++)
		{
			I.consumption();
		}
	}
}

public class H_9Production_Consumption 
{
	public static void main(String[] args)
	{
		Goods I=new Goods();
		prod P=new prod(I);
		cons C=new cons(I);
		Thread I1=new Thread(P);
		I1.start();
		Thread I2=new Thread(C);
		I2.start();
	}

}
