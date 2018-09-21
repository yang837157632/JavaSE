/*
 * 静态代码块
 * 格式:
 * static
 * {
 * 		静态代码块中执行语句
 * }
 * 特点：随着类的加载而执行，并且只会执行一次，优先于主函数
 * 作用：用于给类进行初始化
 */

/*
 * 1、因为有new xx()用到了 xx 类，所以会把它从硬盘上加载进入内存
 * 2、如果有static静态代码块，就会随着类的加载而执行，静态成员和静态方法随着类的加载而加载
 * 3、在堆中开辟空间，分配内存地址
 * 4、在堆中建立对象特有属性，并同时对特有属性进行默认初始化
 * 5、对属性进行显示初始化
 * 6、执行构造代码块，对所有对象进行初始化
 * 7、执行对应的构造函数，对对象进行初始化
 * 8、将内存地址给 x 栈中得的变量
 */

class C_13Class
{
	static
	{
		System.out.println("静态代码块");
	}
	
	{
		System.out.println("构造代码块");
	}
	
	public void print()
	{
		System.out.println("普通代码块");
	}
}

public class C_13Static 
{
	public static void main(String[] args)
	{
		C_13Class M1=new C_13Class();
		M1.print();
		System.out.println();
		C_13Class M2=new C_13Class();
		M2.print();
	}

}
