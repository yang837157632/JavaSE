/*
 * this作用：
 * 用来区分局部变量和成员变量之间同名的情况
 * 代表本对象，代表它所在函数（方法）所属对象的引用
 * 构造方法之间的调用只能通过this语句来完成
 * 构造函数之间进行调用时this语句只能出现在第一行，构造方法要先执行
 * 如果构造方法当中还有初始化，那就执行更细节的初始化
 */

class C_8Class
{
	String name;
	int age;
	
	C_8Class()
	{
		System.out.println("无参构造方法");
	}
	
	C_8Class(String name)
	{
		this();
		this.name=name;
		System.out.println(name);
	}
	
	C_8Class(String name,int age)
	{
		this(name);
		this.age=age;
		System.out.println(age);
	}
}

public class C_8This 
{
	public static void main(String[] args)
	{
		C_8Class H1=new C_8Class();
		System.out.println();
		
		C_8Class H2=new C_8Class("Jim");
		System.out.println();
		
		C_8Class H3=new C_8Class("Cal",34);
	}

}
