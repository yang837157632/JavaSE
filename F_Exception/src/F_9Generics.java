/*
 * 由于类型转换的错误，java虚拟机在编译不会报错，而在运行时报异常，所以安全隐患非常明显。
 * 为此我们需要泛型来弥补这一问题，有了泛型，我们在集合类中添加对象的时候，就不用再强转了。
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
