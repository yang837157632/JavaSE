/*
 * 多态：可以理解为事物存在多种体现形态
 * 多态的体现：父类引用子类对象
 * 多态的前提：
 * （1）必须得类与类之间存在关系，可以使继承关系，也可以是实现关系
 * （2）必须得有重写
 * 多态的好处：大大提高了程序的扩展性
 * 多态的弊端：只能用父类的引用，访问到父类中的成员
 * 多台成员变量的特点：
 * （1）编译期间：参阅的是引用型变量所属的类中是否有调用的方法
 * （2）运行期间：参阅对象所属的类中是否有调用方法
 */

class C_19Class
{
	void run()
	{
		System.out.println("Running");
	}
}

class C_19_1 extends C_19Class
{
	void run()
	{
		System.out.println("Running and jumping");
	}
}

class C_19_2 extends C_19Class
{
	void run()
	{
		System.out.println("Running and playing");
	}
}

class C_19_3 extends C_19Class{}

public class C_19Polymorphism 
{
	public static void main(String[] args)
	{
		C_19_1 S1=new C_19_1();
		function(S1);
		
		C_19_2 S2=new C_19_2();
		function(S2);
		
		C_19_3 S3=new C_19_3();
		function(S3);
	}
	
	public static void function(C_19Class S)
	{
		S.run();
	}

}
