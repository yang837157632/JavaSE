/*
 * ��throws���쳣��ʱ����������������쳣�ķ����ǴӸ���̳еĻ����Ǵӽӿ�ʵ�ֵ�
 * ��ô�����Ǹ��෽����ʵ�ֽӿڷ���ʱ����������е�ԭ������ӿ��е�ԭ���󷽷�û�����쳣
 * �����า�Ǹ���ķ�����ʵ�ֽӿڵķ���Ҳ�������쳣
 * �������������ʱֻ����try...catch
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
