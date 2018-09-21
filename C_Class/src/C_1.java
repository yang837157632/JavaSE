
public class C_1 
{
	public static void main(String[] args)
	{
		C_Class A1=new C_Class();
		A1.name="Lily";
		System.out.println(A1.name);
		
		C_Class A2=new C_Class();
		A2.eat();
		System.out.println(A2.age);
		
		C_Class A3=new C_Class();
		A3.eat();
		A3.age=18;
		System.out.println(A3.age);
		
		C_Class A4=new C_Class();
		A4.sleep("sofa");
		
		C_Class A5=new C_Class();
		A5.age=24;
		int age=A5.getAge();
		System.out.println(age);
	}

}
