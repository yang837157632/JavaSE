/*
 * 一个特殊的类
 * Object：它是java中所有对象的直接或间接父类，根父类，基类
 * 它里面定义的功能是所有对象都应该具备的
 * 当定义一个新类时，没有指明要继承某类，它默认继承Object类
 * 
 *  ==和Object里面的equals其实比较的就是两对象的内存地址是否一致
 */

class C_22Class {}

class C_22_1 extends C_22Class
{
	String name;
	
	public boolean equals(Object V)
	{
		if(V instanceof C_22_1)
		{
			return true;
		}else
		{
			return false;
		}
	}
}

class C_22_2 extends C_22Class {}

public class C_22Object 
{
	public static void main(String[] args)
	{
		System.out.println(new C_22_1());		//toString
		C_22_1 V1=new C_22_1();
		C_22_1 V2=new C_22_1();
		C_22_2 V3=new C_22_2();
		System.out.println(V1.equals(V2));
		System.out.println(V1.equals(V3));
	}

}
