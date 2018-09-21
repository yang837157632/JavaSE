/*
 * static作用：
 * 是一个修饰符，用于修饰成员（变量，方法）
 * 被static修饰后的成员变量只有一份
 * 当成员被static修饰之后，多了一种访问方式，除了可以对象调用之外，还可以被类直接调用（类名.静态变量）
 * 
 * 特点：
 * 1、随着类的加载而被加载
 * 2、优先于对象的存在
 * 3、被所有的对象所共享
 * 4、可以直接被类名所调用
 * 
 * 存放位置：
 * 类变量随着类的加载而存在于data内存区
 * 实例变量随着对象的建立而存在于堆内存
 * 
 * 注意事项：
 * 1、静态的方法只能访问静态的成员
 * 2、非静态的方法既能访问静态的成员，也能访问非静态成员 
 * 3、静态的方法中是不可以定义this、super关键字，因为静态优先于对象存在，所以静态方法不可以出现this
 * 
 * 生命周期：
 * 1、类变量生命周期最长，随着类的消失而消失
 * 2、实例变量生命比类变量短，它随着对象的消失而消失
 */

class C_9Class
{
	String name;
	static String area;
}

public class C_9Static 
{
	public static void main(String[] args)
	{
		System.out.println(C_9Class.area+"\n");
		
		C_9Class I1=new C_9Class();
		I1.area="China";
		System.out.println(I1.area+"\n");
		
		C_9Class I2=new C_9Class();
		System.out.println(I2.area);
	}

}
