class C_3Class
{
	String name;
	int age;
	char color;
	
	public void set(String name,int age,char color)
	{
		this.name=name;
		this.age=age;
		this.color=color;
	}
	
	public String toString()
	{
		return "My name : "+name+" , My age : "+age;
	}
	
	public C_3Class abc()
	{
		return this;
	}
}

public class C_3toString 
{
	public static void main(String[] args)
	{
		C_3Class C1=new C_3Class();
		System.out.println(C1);
		
		C_3Class C2=new C_3Class();
		C2.name="Angela";
		C2.age=17;
		System.out.println(C2);
		
		C_3Class C3=new C_3Class();
		C3.set("Kitty",2,'r');
		System.out.println(C3);
		
		C_3Class C4=new C_3Class();
		C4=C3.abc();
		System.out.println(C4.color);
	}

}
