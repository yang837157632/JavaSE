/*
 * 对象的转型：
 * 1、对象的向上转型 子类转成父类 默认执行 父类引用指向子类
 * 2、对象的向下转型 父类转成子类 强制进行
 * 
 * 关键字：instanceof 测试左边的对象是否是右边类的实例
 * 如果是返回true；不是返回false
 */

class C_18Class
{
	void eat()
	{
		System.out.println("Eating");
	}
}

class C_18_1 extends C_18Class
{
	void egg()
	{
		System.out.println("Egging");
	}
}

class C_18_2 extends C_18Class
{
	void crow()
	{
		System.out.println("Crowing");
	}
}

public class C_18ObjectsTransition 
{
	public static void main(String[] args)
	{
		C_18Class R1=new C_18_1();						//向上转型
		System.out.println(R1 instanceof C_18Class);	//	T
		System.out.println(R1 instanceof C_18_1);		//	T
		System.out.println(R1 instanceof C_18_2);		//	F
		
		C_18_1 R2=(C_18_1)R1;							//向下转型
//		C_18_2 R2=(C_18_2)R1							无关类之间不能转换
		System.out.println(R2 instanceof C_18Class);	//	T
		System.out.println(R2 instanceof C_18_1);		//	T
//		System.out.println(R2 instanceof C_18_2);		无关类之间不能比较
		
		C_18Class R3=new C_18Class();
		System.out.println(R3 instanceof C_18Class);	//	T
		System.out.println(R3 instanceof C_18_1);		//	F
		System.out.println(R3 instanceof C_18_2);		//	F
	}
}
