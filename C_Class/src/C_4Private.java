import java.util.Scanner;

class C_4Class
{
	private String name;
	private int age;
	private String gender;
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void setAge(int age)
	{
		this.age=age;
	}
	
	public int getAge()
	{
		return this.age;
	}
	
	public void setGender(String gender)
	{
		if(gender.equals("F")||gender.equals("M"))
		{
			this.gender=gender;
		}else
		{
			System.out.println("Wrong input");
		}
	}
	
	public String getGender()
	{
		return this.gender;
	}
	
	public String toString()
	{
		return this.name+"\t"+this.age+"\t"+this.gender;
	}
}

public class C_4Private 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		C_4Class D1=new C_4Class();
		D1.setName("Star");
		D1.setAge(25);
		System.out.print("Please input your gender(F/M): ");
		D1.setGender(in.next());
		System.out.println(D1);
	}

}
