/*
 * 接口：提高了功能的扩展性，因为它降低了事物与事物之间的耦合性（关系紧密程度）
 * 
 * 父类中定义的是多个类中共性的基本功能
 * 接口中定义的是扩展功能
 * 
 * 接口好处：可以实现多实现，也就是一个类可以实现多个接口
 */

class C_28Class
{
	String name;
	int age;
}

interface C_28Inter
{
	public abstract void Sun();
}

class C_28_1 extends C_28Class implements C_28Inter
{
	public void Sun()
	{
		System.out.println("Sunning");
	}
}

class C_28_2 extends C_28Class {}

public class C_28Interface 
{
	public static void main(String[] args)
	{
		C_28_1 AB=new C_28_1();
		AB.Sun();
	}

}
