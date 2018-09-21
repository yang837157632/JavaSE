/*
 * 用throws抛异常的时候，如果向主调处抛异常的方法是从父类继承的或者是从接口实现的
 * 那么，覆盖父类方法或实现接口方法时，如果父类中的原方法或接口中的原抽象方法没有抛异常
 * 则子类覆盖父类的方法或实现接口的方法也不能抛异常
 * 当出现这种情况时只能用try...catch
 */
class H_5Class implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+"\t"+i);
			try
			{
				Thread.sleep(1000);			//1000ms
			}catch(Exception e){}
		}
	}
}

public class H_5Sleep 
{
	public static void main(String[] args)
	{
		Thread E=new Thread(new H_5Class());
		E.start();
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+"\t"+i);
		}
	}
}
