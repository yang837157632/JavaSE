//反射机制是将泛型固定的所有方法和成员全部可以显示出来，以供程序员可以确定程序的编写是否有误的机制。

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
		System.out.println("ClassName: "+j.getClass().getName());				//取类型名称
		Method[] M=j.getClass().getDeclaredMethods();
		for(int i=0;i<M.length;i++)
		{
			System.out.println("第 "+(i+1)+" 个函数名为\t "+M[i].getName());		//取方法名称
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
