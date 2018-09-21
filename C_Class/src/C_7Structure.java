/*
 * 构造代码块特点：
 * 对象一建立就运行了，而且优先于构造函数执行
 * 作用：给对象进行初始化的
 * 
 * 构造代码块和构造方法的区别：
 * 构造对象是对应的对象进行初始化
 * 构造代码块是给所有的对象进行统一的初始化
 */

class C_7Class
{
	String name;
	
	C_7Class()
	{
		System.out.println("无参代码块\n");
	}
	
	C_7Class(String name)
	{
		this.name=name;
		System.out.println("有参代码块\n");
	}
	
	{
		System.out.println("构造代码块");
	}
}
public class C_7Structure 
{
	public static void main(String[] args)
	{
		C_7Class G1=new C_7Class();
		C_7Class G2=new C_7Class("Klevin");
	}

}
