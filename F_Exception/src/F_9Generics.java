/*
 * ��������ת���Ĵ���java������ڱ��벻�ᱨ����������ʱ���쳣�����԰�ȫ�����ǳ����ԡ�
 * Ϊ��������Ҫ�������ֲ���һ���⣬���˷��ͣ������ڼ���������Ӷ����ʱ�򣬾Ͳ�����ǿת�ˡ�
 */

import java.util.*;
public class F_9Generics 
{
	public static void main(String[] args)
	{
		ArrayList<Beverages> AL=new ArrayList<Beverages>();
		Beverages B=new Beverages("Vanilla",30.5f,"Green");
		AL.add(B);
		Beverages b=(Beverages)AL.get(0);
		
		HashMap<String,Snakes> HM=new HashMap<String,Snakes>();		
		Snakes S=new Snakes("gum",4.3f);
		HM.put("1",S);
		Snakes s=(Snakes)HM.get("1");
		
		System.out.println("Testing");
	}
}

class Snakes
{
	private String name;
	private float price;
	
	Snakes(String name,float price)
	{
		this.name=name;
		this.price=price;
	}
}

class Beverages
{
	private String name;
	private float price;
	private String color;
	
	Beverages(String name,float price,String color)
	{
		this.name=name;
		this.price=price;
		this.color=color;
	}
}
