/*
 * 什么时候使用静态
 * static所修饰的内容是成员（变量、方法）
 * 
 * 什么时候使用静态的成员变量：
 * 当属于同一类的所有对象出现共享数据时
 * 需要将存储这个共享数据的成员变量用static修饰
 * 
 * 什么时候使用静态方法：
 * 当功能内部没有访问到非静态的成员时（对象特有的数据）
 * 那么该功能可以定义为静态的
 */

class C_10Class
{
	static void print()
	{
		System.out.println("hello");
	}
}

public class C_10Static 
{
	public static void main(String[] args)
	{
		C_10Class.print();
		C_10Class J1=new C_10Class();
		J1.print();
	}

}
