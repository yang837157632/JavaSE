class H_41Class implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("1�̣߳� "+i);
		}
	}
}

class H_42Class implements Runnable
{
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("��2���߳��������У� "+i);
		}
	}
}

public class H_4PriorityI 
{
	public static void main(String[] args)
	{
		Thread D1=new Thread(new H_41Class());
		Thread D2=new Thread(new H_42Class());			
		//�߳�Ĭ�ϼ���Ϊ5
		D2.setPriority(Thread.NORM_PRIORITY+3);			
		//����Խ�����ȼ�Խ��,���Ǿ���
		D1.start();
		D2.start();
	}
}
