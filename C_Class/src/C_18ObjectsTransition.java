/*
 * �����ת�ͣ�
 * 1�����������ת�� ����ת�ɸ��� Ĭ��ִ�� ��������ָ������
 * 2�����������ת�� ����ת������ ǿ�ƽ���
 * 
 * �ؼ��֣�instanceof ������ߵĶ����Ƿ����ұ����ʵ��
 * ����Ƿ���true�����Ƿ���false
 */

class C_18Class
{
	void eat()
	{
		System.out.println("Eating");
	}
}

class C_18_1 extends C_18Class
{
	void egg()
	{
		System.out.println("Egging");
	}
}

class C_18_2 extends C_18Class
{
	void crow()
	{
		System.out.println("Crowing");
	}
}

public class C_18ObjectsTransition 
{
	public static void main(String[] args)
	{
		C_18Class R1=new C_18_1();						//����ת��
		System.out.println(R1 instanceof C_18Class);	//	T
		System.out.println(R1 instanceof C_18_1);		//	T
		System.out.println(R1 instanceof C_18_2);		//	F
		
		C_18_1 R2=(C_18_1)R1;							//����ת��
//		C_18_2 R2=(C_18_2)R1							�޹���֮�䲻��ת��
		System.out.println(R2 instanceof C_18Class);	//	T
		System.out.println(R2 instanceof C_18_1);		//	T
//		System.out.println(R2 instanceof C_18_2);		�޹���֮�䲻�ܱȽ�
		
		C_18Class R3=new C_18Class();
		System.out.println(R3 instanceof C_18Class);	//	T
		System.out.println(R3 instanceof C_18_1);		//	F
		System.out.println(R3 instanceof C_18_2);		//	F
	}
}
