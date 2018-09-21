import java.util.*;
public class F_7Vector_Stack 
{
	public static void main(String[] args)
	{
		Sp sp1=new Sp("001","Chips",2.5f);
		Sp sp2=new Sp("002","Cream",5.5f);
		Sp sp3=new Sp("003","Bread",10);
		
		Vector G1=new Vector();
		G1.add(sp1);
		G1.add(sp2);
		G1.add(sp3);
		System.out.print("Vector: ");
		for(int i=0;i<G1.size();i++)
		{
			System.out.print("\t"+((Sp)G1.get(i)).getName());
		}
		
		Stack G2=new Stack();
		G2.add(sp1);
		G2.add(sp2);
		G2.add(sp3);
		System.out.print("\nStack: \t");
		for(int i=0;i<G2.size();i++)
		{
			System.out.print("\t"+((Sp)G2.get(i)).getName());
		}
	}

}
