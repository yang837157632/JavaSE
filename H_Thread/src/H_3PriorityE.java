class H_3Class extends Thread
{
	public void run()
	{
		System.out.println(Thread.currentThread().getName()+"��ִ��");
	}
}

public class H_3PriorityE 
{
	public static void main(String[] args)
	{
		H_3Class C1=new H_3Class();
		C1.setName("�߳�1");
		C1.start();
		H_3Class C2=new H_3Class();
		C2.setName("�߳�2");
		C2.start();
		H_3Class C3=new H_3Class();
		C3.setName("�߳�3");
		C3.start();
		System.out.println(Thread.currentThread().getName()+"��ִ��");
	}
}
