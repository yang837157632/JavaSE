/*
 * java中一般情况下，不可以再用==来比较是否相等的情况，而是要用Equals方法来比较。
 * Equals方法属于Object类并且不是final类型，所以任何类都可以继承并且覆盖该方法。
 * Equals方法在一般情况下都需要覆盖成自己想要的方法。而且配合多态可以实现强大的“比较”功能。
 * 可以比较类中的任何数据，可以根据东西的需求来定义两个对象是否相等的条件。
 */

class F_3Class
{
	private int i;
	
	F_3Class(int i)
	{
		this.i=i;
	}
	
	public boolean equals(F_3Class C)
	{
		if(this.i==C.i)
		{
			return true;
		}
		return false;
	}
}

class F_3_1 extends F_3Class
{
	private int j;
	
	F_3_1(int j)
	{
		super(j);
		this.j=j;
	}
}

public class F_3Equals 
{
	public static void main(String[] args)
	{
		F_3Class C1=new F_3Class(10);
		F_3Class C2=new F_3Class(10);
		System.out.print("C_Class\t");
		System.out.println(C1.equals(C2));
		
		F_3_1 C3=new F_3_1(20);
		F_3_1 C4=new F_3_1(30);
		System.out.print("C_3_1\t");
		System.out.println(C3.equals(C4));
	}

}
