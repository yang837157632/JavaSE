//���̳��࣬���Ǹĳ���ʵ�ֽӿ�

class H_2Class implements Runnable
{		
	public void run()
	{
		for(int i=0;i<10;i++)
		{
			System.out.println("�Ӻ���");
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
			System.out.println("������");
		}
	}
}
