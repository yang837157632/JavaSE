/*
 * synchronized �������ǣ�������Ͻ�Ĵ��벿�֣�Ҫôȫ��ִ�У�Ҫôȫ����ִ��
 * synchronized ���κ�������Ҫ�ַ������൱��Ĭ����this��	public synchronized void run()
 */
class H_8Class implements Runnable
{
	public static int tickets=100;
	String H=new String("8");		//�ַ������ⶨ�壬�����ں����ϱ�
	public void run()
	{
		while(true)
		{
			synchronized(H)
			{		//�ȿ������δ���飬�ֿ������κ���
				if(tickets>0)
				{
					System.out.println(Thread.currentThread().getName()+"��վ��������"+(101-tickets)+"�ų�Ʊ");
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
		h1.setName("�Ϻ�");
		h1.start();
		Thread h2=new Thread(h);
		h2.setName("����");
		h2.start();
	}
}
