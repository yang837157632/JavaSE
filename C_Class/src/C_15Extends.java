/*
 * �̳еĸ�����
 * 1������˴���ĸ����ԣ����˴���
 * 2����������֮������˼̳й�ϵ�������˺���Ķ�̬���ԵĴ���
 * 3������ӵ�и���ĳ�Ա�����಻��ӵ�и����б�private���κ�ĳ�Ա
 * 4���ڶ��̳������²������ӵ������������ϵ�ĳ�Ա�����ϲ�ĵĸ������涨����������Ĺ�������
 * ע�⣺
 * 1��ǧ��ҪΪ�˻�ȡ������Ĺ��ܼ򻯴��룬�������̳й�ϵ������Ҫ������֮����ڼ̳й�ϵ
 * 2��java��֧�ֶ�̳У�ֻ֧�ֵ��̳У���Ϊ��̳д��ڰ�ȫ��������������ඨ������ͬ�ĳ�Ա���������ȷ��������һ��
 *    java�������ֻ��ƣ���������һ�ַ�ʽ�����ֶ�ʵ��
 */

//���࣬���࣬����
class C_15Class
{
	String buru="Breast-feeding";
}

//���࣬������
class C_15_1 extends C_15Class
{
	private String color;
	String name;
	int age;
}

class C_15_1_1 extends C_15_1
{
	public void jump()
	{
		System.out.println("Jumping");
	}
}

class C_15_1_2 extends C_15_1
{
	public void leap()
	{
		System.out.println("Leaping");
	}
}

public class C_15Extends 
{
	public static void main(String[] args)
	{
		C_15_1_1 O1=new C_15_1_1();
		System.out.println(O1.buru);
		
		C_15_1_2 O2=new C_15_1_2();
		O2.name="Antelope";
		O2.age=13;
		System.out.println(O2.name+"\t"+O2.age);		
	}

}
