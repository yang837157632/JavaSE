/*
 * 子父类构造函数
 * 有了子父类之后构造函数的特点：
 * 在对子类对象进行初始化的时候，父类的构造方法也会执行，那是因为子类的构造方法默认第一行有一条隐式的语句super（）
 * 子类每个构造方法第一行都有一个隐式的super（）
 */

class C_17Class
{
	String name;
	
	C_17Class()
	{
		System.out.println("父类无参构造方法");
	}
	
	C_17Class(String name)
	{
		this.name=name;
		System.out.println("父类有参构造方法");
	}
}

class C_17_1 extends C_17Class
{
	C_17_1()
	{
		super("ABC");
		System.out.println("子类无参构造方法");
	}
	
	C_17_1(String name)
	{
		System.out.println("子类有参构造方法");
	}
}

public class C_17Super 
{
	public static void main(String[] args)
	{
		C_17_1 Q1=new C_17_1();
		System.out.println();
		C_17_1 Q2=new C_17_1("XYZ");
	}

}
