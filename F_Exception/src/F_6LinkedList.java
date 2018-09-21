//LinkedList 与ArrayList相仿，也是一种集合类

import java.util.*;
public class F_6LinkedList 
{
	public static void main(String [] args)
	{
		Sp sp1=new Sp("001","Chips",2.5f);
		Sp sp2=new Sp("002","Cream",5.5f);
		Sp sp3=new Sp("003","Bread",10);
		LinkedList F1=new LinkedList();
		F1.add(sp1);
		F1.add(sp2);
		F1.add(sp3);
		for(int i=0;i<F1.size();i++)
		{
			System.out.print("\t"+((Sp)F1.get(i)).getName());
		}
		System.out.print("\n\tgetFirst: "+((Sp)F1.getFirst()).getName());
		System.out.print("\n\tgetLast: "+((Sp)F1.getLast()).getName()+"\n\n");
		
		LinkedList F2=new LinkedList();
		F2.addFirst(sp1);
		F2.addFirst(sp2);
		F2.addFirst(sp3);
		for(int i=0;i<F2.size();i++)
		{
			System.out.print("\t"+((Sp)F2.get(i)).getName());
		}
		System.out.print("\n\tgetFirst: "+((Sp)F2.getFirst()).getName());
		System.out.print("\n\tgetLast: "+((Sp)F2.getLast()).getName()+"\n\n");
		
		LinkedList F3=new LinkedList();
		F3.addLast(sp1);
		F3.addLast(sp2);
		F3.addLast(sp3);
		for(int i=0;i<F3.size();i++)
		{
			System.out.print("\t"+((Sp)F3.get(i)).getName());
		}
		System.out.print("\n\tgetFirst: "+((Sp)F3.getFirst()).getName());
		System.out.print("\n\tgetLast: "+((Sp)F3.getLast()).getName());
	}

}
