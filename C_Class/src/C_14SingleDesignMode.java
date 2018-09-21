/*
 * 单例设计模式：解决一个类只在内存中存在一个对象
 * 
 * 设计模式：针对此类问题最有效的解决方法
 * java中有23种设计模式
 * 
 * 如何让一个类在内存中只存在于一个对象？
 * 1、禁止其他的应用程序，通过此类来创建对象
 * 2、既然外部不能通过此类创建对象了，我们要用对象，就需要在本类里面创建本类对象
 * 3、为了其他应用程序能够访问到本类里面创建的对象，需要对外界提供一种访问方式
 * 
 * 如何用代码块体现出来：
 * 1、私有化构造方法
 * 2、在本类中创建本类对象
 * 3、对外界提供访问的方法
 */

class C_14Class
{
	String name;
	int age;
	
	private C_14Class(){}
	
	static C_14Class N=new C_14Class();
	
	public static C_14Class getInstance()
	{
		return N;
	}
}

public class C_14SingleDesignMode 
{
	public static void main(String[] args)
	{
		C_14Class N1=C_14Class.getInstance();
		N1.name="Bell";
		C_14Class N2=C_14Class.getInstance();
		N2.age=25;
		System.out.println(N2.name);
		System.out.println(N1.age);
	}
}
