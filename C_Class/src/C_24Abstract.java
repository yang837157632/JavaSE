/*
 * abstract: 是一个修饰符，可以修饰类，方法
 * 当我们多个类存在相似功能，但功能的主体不同，这时我们进行向上抽取，且只抽取功能的定义不抽取功能的主体
 * 
 * 抽象类的特点:
 * 1、抽象方法一定要在抽象类中
 * 2、抽象类和抽象方法必须要被abstract关键字修饰，abstract只能修饰类和函数
 * 3、抽象的类是不能被创建对象，因为调用对象的方法没意义
 * 4、抽象类中的方法要被使用，必须有子类重写抽象类中的方法，并且创建子类对象来调用
 * 5、抽象类中可以定义非抽象的方法，有时我们需要此类不能被new关键字创建对象时，可以用abstract将此类变成抽象类
 * 6、子类如果只重写一部分的抽闲方法，那么该子类还是一个抽象类。如果抽象类的方法要被使用，子类必须重写抽象类中的所有方法
 * 
 * 注意事项：抽象类和普通类没有太大的不同
 * 1、抽象类无法通过new关键字创建对象
 * 2、抽象类里面可有抽象方法
 */

abstract class C_24Class
{
	abstract void rotate();
	void show()
	{
		System.out.println("Shining");
	}
}

class C_24_1 extends C_24Class
{
	void rotate()
	{
		System.out.println("Irregulal rotating");
	}
}

class C_24_2 extends C_24Class
{
	void rotate()
	{
		System.out.println("Eclipse rotating");
	}
}
public class C_24Abstract 
{
	public static void main(String[] args)
	{
		C_24Class X1=new C_24_1();
		C_24_2 X2=new C_24_2();
		X1.rotate();
		X1.show();
		X2.rotate();
		X2.show();
	}

}
