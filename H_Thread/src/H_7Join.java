class H_7Class implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("\t���̣߳� "+i);
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
			G.join();		//����ʱ����ǰ�߳���ͣ��ֱ������join��������Ӧ���̶߳�Ӧ�������ż���ִ�г���
		}catch(Exception e){}
		for(int i=0;i<15;i++)
		{
			System.out.println("���̣߳� "+i);
		}
	}

}
