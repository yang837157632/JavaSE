/*
 * java不支持多继承，因为存在安全隐患，当父类中定义了相同功能，功能内容不同时，子类不确定要运行哪一个
 * 但是java保留了这种机制，并用另一种体现形式来完成表示——多实现
 * 
 * 关系:
 * 类与类之间：继承关系
 * 接口与类之间：实现关系
 * 接口与接口之间：继承关系
 */

interface C_27Inter
{
	public abstract int bloom(int age);
}

interface C_27_1 extends C_27Inter
{
	public abstract void action();
}

interface C_27_2 extends C_27Inter
{
	public abstract void speak();
}

class C_27Class implements C_27_1,C_27_2
{
	public int bloom(int age)
	{
		return age;
	}
	
	public void action()
	{
		System.out.println("Action");
	}
	
	public void speak()
	{
		System.out.println("Speaking");
	}
}

public class C_27Implements 
{
	public static void main(String[] args)
	{
		C_27Class AA=new C_27Class();
		int age=AA.bloom(5);
		System.out.println("It took "+age+" years to bloom!\n");
		AA.action();
		AA.speak();		
	}

}
