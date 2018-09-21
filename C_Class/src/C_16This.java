/*
 * 子父类成员特点
 * 成员：
 * 1、成员变量
 * 2、函数
 * 3、构造函数
 * 
 * 变量：
 * this 代表当前对象的引用 
 * this.变量 首先在本类中赵所需要的这个变量，如果没有找到再在父类中找
 * super 用于访问当前对象的父类成员
 * super.name 直接父类中找所需变量
 * 
 * 函数
 * 当子类中出现和父类一样的函数时，子类对象调用该函数时，运行的是子类中的函数，如同父类中的函数被覆盖一样，这种情况就是函数的另一种特性：重写/覆盖
 * 子类覆盖父类时，必须要保证子类权限大于等于父类，才可以覆盖，否则编译出错
 * 访问权限修饰符：public>default>private 成员前面没加任何访问权限，修饰符默认权限就是default
 * 静态的函数只能覆盖静态的
 * 重载：只看重名的方法的参数列表
 * 重写：子父类方法要一模一样
 */

class C_16Class
{
	String name="Monkey";
	String color;
	void watch()
	{
		System.out.println("Watching");
	}
}

class C_16_1 extends C_16Class
{
	String name="Golden Monkey";
	void print()
	{
		System.out.println(this.name);
		System.out.println(super.name);
	}
}

class C_16_2 extends C_16Class
{
	void watch()
	{
		color="Black";
		System.out.println(color+"\t watching");
	}
}

public class C_16This 
{
	public static void main(String[] args)
	{
		C_16_1 P1=new C_16_1();
		P1.print();
		P1.watch();
		
		C_16_2 P2=new C_16_2();
		P2.watch();
	}

}
