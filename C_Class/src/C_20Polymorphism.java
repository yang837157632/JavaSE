import java.util.Random;

public class C_20Polymorphism 
{
	public static void main(String[] args)
	{
		Random N=new Random();
		int n=N.nextInt(5);
		C_20Class T=null;
		
		switch(n)
		{
		case 0:
			T=new C_20_1();
			break;
		case 1:
			T=new C_20_2();
			break;
		case 2:
			T=new C_20_3();
			break;
		case 3:
			T=new C_20_4();
			break;
		case 4:
			T=new C_20_5();
			break;
		}
		T.deform();
	}

}

class C_20Class
{
	void deform()
	{
		System.out.println("Deforming");
	}
}

class C_20_1 extends C_20Class
{
	void deform()
	{
		System.out.println("Square is deforming");
	}
}

class C_20_2 extends C_20Class
{
	void deform()
	{
		System.out.println("Rectangle is deforming");
	}
}

class C_20_3 extends C_20Class
{
	void deform()
	{
		System.out.println("Z_shaped is deforming");
	}
}

class C_20_4 extends C_20Class
{
	void deform()
	{
		System.out.println("L_shaped is deforming");
	}
}

class C_20_5 extends C_20Class {}