/*
 * �����Ͻ���ָ���Ϊ����
 * �����ͬʱ�����г�Ϊ����
 * �����в�ͬ��ִ��·����Ϊ�߳�
 * ���̱߳�̼򵥣�Ч�ʸߣ�������Դ����
 * 
 * �߳�ͬ��
 * �߳�ͬ����ָһ�γ���ִ�й����У����۳ɹ�����ʧ�ܣ������̶߳���ȴ���γ���ִ����ϣ��Ż�ת�������̡߳�
 * �������Ա�֤����������ԺͰ�ȫ�ԡ�
 */

class H_1Class extends Thread
{		
	public void run()
	{				//run�����Ǹ��ǵĸ��෽��
		for(int i=0;i<10;i++)
		{
			System.out.println("�Ӻ���");
		}
	}
}

public class H_1Extends 
{
	public static void main(String[] args)
	{
		H_1Class A=new H_1Class();
		A.run();				//��ͨ��run���÷���
		System.out.println();
		A.start();				//���õ�start�����������ȥִ��run������start�Ὺ��һ���̣߳�������ֱ�ӵ���
		for(int i=0;i<10;i++)
		{
			System.out.println("������");
		}
	}
}
