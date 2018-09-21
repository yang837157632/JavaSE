class C_2Class
{
	String name;
	
	public String print(String a,int b,char c)
	{
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		System.out.println("c = "+c);
		return a;
	}
	
	public void str(int a)
	{
		if(a==0)
		{
			System.out.println("Hello");
		}else
		{
			return;
		}
	}
}

public class C_2 
{
	public static void main(String[] args)
	{
		C_2Class B1=new C_2Class();
		System.out.println(B1.name);
		B1.str(0);
		C_2Class B2=new C_2Class();
		B2.str(1);
		String s=B2.print("Hello", 12, 'F');
		System.out.println(s);
	}
}
