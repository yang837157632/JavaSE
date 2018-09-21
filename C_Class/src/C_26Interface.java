/*
 * 接口：初步理解，接口是一个特殊的抽象类，当抽象类中全部是抽象方法时，可以通过接口的形式来体现
 * class用于定义类，interface用于定义接口
 * 
 * 接口中成员的格式：
 * 1、public static final String NAME="Star";		全局常量
 * 2、public abstract void show();					抽象方法
 * 
 * 注意：
 * 1、接口中只能出现public访问修饰符
 * 2、接口中不可以创建对象，因为里面有抽象方法，需要被子类实现，子类对接口真的所有抽象方法实现后，子类才能够实例化，否则子类就是一个抽象类
 */

interface C_26Inter
{
	public static final String NAME="Star";
	public abstract void show();
}

class C_26_1 implements C_26Inter
{
	public void show()
	{
		System.out.println("Leap Year");
	}
}

public class C_26Interface 
{
	public static void main(String[] args)
	{
		C_26_1 Z1=new C_26_1();
		System.out.println(Z1.NAME);
		Z1.show();
		System.out.println(C_26_1.NAME);
		System.out.println(C_26Inter.NAME);
	}
}
