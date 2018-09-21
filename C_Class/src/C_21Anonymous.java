/*
 * 匿名对象：没有名字的对象
 * 匿名对象的使用方式：
 * （1）当对象的方法只调用一次时，我们可以用匿名对象来完成
 * （2）匿名对象可以当做实参传递
 */

class C_21Class
{
	void eat()
	{
		System.out.println("Eating");
	}
	
	void sleep()
	{
		System.out.println("Sleeping");
	}
}

public class C_21Anonymous 
{
	public static void main(String[] args)
	{
		new C_21Class().eat();
		eg(new C_21Class());
	}
	
	public static void eg(C_21Class U)
	{
		U.sleep();
	}

}
