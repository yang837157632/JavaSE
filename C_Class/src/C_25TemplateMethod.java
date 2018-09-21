/*
 * 模板方法设计模式
 * 要求：求一段代码运行所花费的时间
 * 原理：结束时间减去开始时间
 * 模板方法设计模式
 * 定义功能时，功能的一部分是确定的，而确定的部分在使用不确定，那么这时就得将不确定的部分暴露出去，由该子类去完成
 */

abstract class C_25Class
{
	public abstract void function();
	
	public final void time()
	{
		long start=System.currentTimeMillis();
		function();
		long stop=System.currentTimeMillis();
		System.out.println("\n共花费了 "+(stop-start)+" ms.");
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
