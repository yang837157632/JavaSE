/*
 * ģ�巽�����ģʽ
 * Ҫ����һ�δ������������ѵ�ʱ��
 * ԭ������ʱ���ȥ��ʼʱ��
 * ģ�巽�����ģʽ
 * ���幦��ʱ�����ܵ�һ������ȷ���ģ���ȷ���Ĳ�����ʹ�ò�ȷ������ô��ʱ�͵ý���ȷ���Ĳ��ֱ�¶��ȥ���ɸ�����ȥ���
 */

abstract class C_25Class
{
	public abstract void function();
	
	public final void time()
	{
		long start=System.currentTimeMillis();
		function();
		long stop=System.currentTimeMillis();
		System.out.println("\n�������� "+(stop-start)+" ms.");
	}
}

class C_25_1 extends C_25Class
{
	public void function()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.print("5\t");
		}
	}
}

class C_25_2 extends C_25Class
{
	public void function()
	{
		for(int i=0;i<1000;i++)
		{
			System.out.print("6\t");
		}
	}
}

public class C_25TemplateMethod 
{
	public static void main(String[] args)
	{
		C_25_1 Y1=new C_25_1();
		Y1.time();
		
		C_25_2 Y2=new C_25_2();
		Y2.time();
	}
}
