/*
 * 继承的概述：
 * 1、提高了代码的复用性，简化了代码
 * 2、让类与类之间产生了继承关系，才有了后面的多态特性的存在
 * 3、子类拥有父类的成员，子类不能拥有父类中被private修饰后的成员
 * 4、在多层继承中最下层的子类拥有整个集成体系的成员，最上层的的父类里面定义所有子类的共性描述
 * 注意：
 * 1、千万不要为了获取其他类的功能简化代码，而建立继承关系，必须要类与类之间存在继承关系
 * 2、java不支持多继承，只支持单继承，因为多继承存在安全隐患，当多个父类定义了相同的成员，子类对象不确定运行哪一个
 *    java保留这种机制，并用了另一种方式来体现多实现
 */

//父类，超类，基类
class C_15Class
{
	String buru="Breast-feeding";
}

//子类，导出类
class C_15_1 extends C_15Class
{
	private String color;
	String name;
	int age;
}

class C_15_1_1 extends C_15_1
{
	public void jump()
	{
		System.out.println("Jumping");
	}
}

class C_15_1_2 extends C_15_1
{
	public void leap()
	{
		System.out.println("Leaping");
	}
}

public class C_15Extends 
{
	public static void main(String[] args)
	{
		C_15_1_1 O1=new C_15_1_1();
		System.out.println(O1.buru);
		
		C_15_1_2 O2=new C_15_1_2();
		O2.name="Antelope";
		O2.age=13;
		System.out.println(O2.name+"\t"+O2.age);		
	}

}
