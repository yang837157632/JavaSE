//��������ǽ����͹̶������з����ͳ�Աȫ��������ʾ�������Թ�����Ա����ȷ������ı�д�Ƿ�����Ļ��ơ�

import java.lang.reflect.*;
public class F_10Reflection 
{
	public static void main(String[] args)
	{
		goods<String> j1=new goods<String>("Computer");
		j1.classname();
		goods<Integer> j2=new goods<Integer>(999);
		j2.classname();
		goods<toy> j3=new goods<toy>(new toy());
		j3.classname();
	}
}

class goods<J>
{
	private J j;
	
	goods(J j)
	{
		this.j=j;
	}
	
	public void classname()
	{
		System.out.println("ClassName: "+j.getClass().getName());				//ȡ��������
		Method[] M=j.getClass().getDeclaredMethods();
		for(int i=0;i<M.length;i++)
		{
			System.out.println("�� "+(i+1)+" ��������Ϊ\t "+M[i].getName());		//ȡ��������
		}
	}
}

class toy
{
	static
	{
		System.out.println("Toy");
	}
	
	{
		System.out.println("Begining");
	}
	
	public void play()
	{
		System.out.println("Playing");
	}
	
	public int plus(int a,int b)
	{
		return a+b;
	}
}
