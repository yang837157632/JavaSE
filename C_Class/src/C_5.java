
class C_5Class
{
	public void max(double a,double b)
	{
		System.out.println("First method : "+(a>b?a:b));
	}
	
	public void max(double a,double b,double c)
	{
		double max=a>b?a:b;
		System.out.println("Second method : "+(max>c?max:c));
	}
}

public class C_5 
{
	public static void main(String[] args)
	{
		C_5Class E1=new C_5Class();
		E1.max(6,3);
		E1.max(3.4,4);
		E1.max(3.1,4,2.3);
	}
}
