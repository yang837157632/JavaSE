/*
 * java��һ������£�����������==���Ƚ��Ƿ���ȵ����������Ҫ��Equals�������Ƚϡ�
 * Equals��������Object�ಢ�Ҳ���final���ͣ������κ��඼���Լ̳в��Ҹ��Ǹ÷�����
 * Equals������һ������¶���Ҫ���ǳ��Լ���Ҫ�ķ�����������϶�̬����ʵ��ǿ��ġ��Ƚϡ����ܡ�
 * ���ԱȽ����е��κ����ݣ����Ը��ݶ������������������������Ƿ���ȵ�������
 */

class F_3Class
{
	private int i;
	
	F_3Class(int i)
	{
		this.i=i;
	}
	
	public boolean equals(F_3Class C)
	{
		if(this.i==C.i)
		{
			return true;
		}
		return false;
	}
}

class F_3_1 extends F_3Class
{
	private int j;
	
	F_3_1(int j)
	{
		super(j);
		this.j=j;
	}
}

public class F_3Equals 
{
	public static void main(String[] args)
	{
		F_3Class C1=new F_3Class(10);
		F_3Class C2=new F_3Class(10);
		System.out.print("C_Class\t");
		System.out.println(C1.equals(C2));
		
		F_3_1 C3=new F_3_1(20);
		F_3_1 C4=new F_3_1(30);
		System.out.print("C_3_1\t");
		System.out.println(C3.equals(C4));
	}

}
