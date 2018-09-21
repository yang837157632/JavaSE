/*
 * HashMap 键值出现重复时可覆盖
 * 
 * List集合类与Map集合类的区别：
 * 键值：能唯一标识某一事物的值称为键值。
 * 注意：键值是为了唯一标识事物而单独添加的属性，一定不要用事物本身的属性来做键值。
 * List没有键值，Map有键值。
 * 
 * ArrayList和Vector的区别与HashMap和Hashtable的区别相同，它们是：
 * ArrayList和HashMap都是线程异步的，所以它们的特点是效率高但是安全性低。
 * Vector和Hashtable都是线程同步的，所以他们的特点是效率低但是安全性高。
 */

import java.util.*;
public class F_8HashMap 
{
	public static void main(String[] args)
	{
		HashMap H=new HashMap();
		Sp sp0=new Sp("001","Shrimp",100);
		Sp sp1=new Sp("001","Chips",2.5f);
		Sp sp2=new Sp("002","Cream",5.5f);
		Sp sp3=new Sp("003","Bread",10);
		
		H.put("001",sp0);
		H.put("001",sp1);
		H.put("002",sp2);
		H.put("003",sp3);
		
		if(H.containsKey("001"))
		{
			Sp sp=(Sp)H.get("001");
			System.out.print(sp.getNo()+"\t"+sp.getName()+"\n\n");
		}else
		{
			System.out.println("没有编号为 001 的食品");
		}
		
		System.out.println("No\tName\tPrice");
		Iterator it=H.keySet().iterator();
		while(it.hasNext())
		{
			String key=it.next().toString();
			Sp sp=(Sp)H.get(key);
			System.out.print(sp.getNo()+"\t"+sp.getName()+"\t"+sp.getPrice()+"\n");
		}
	}
}
