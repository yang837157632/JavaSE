
class C_6Class
{
	private String name;
	private int age;
	
	C_6Class() {}
	
	C_6Class(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	
	void get()
	{
		System.out.println(this.name);
	}
}

public class C_6 
{
	public static void main(String[] args)
	{
		C_6Class F1=new C_6Class();
		F1.get();
		
		C_6Class F2=new C_6Class("Betty",4);
		F2.get();
	}

}
