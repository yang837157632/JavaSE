import java.util.*;
import java.io.*;

public class F_5 
{
	public static void main(String[] args) throws Exception	
	{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		spgl shipin=new spgl();
		while(true)
		{
			System.out.println("\n--请按提示选择以下功能--");
			System.out.println("--1.添加食品--");
			System.out.println("--2.查找食品--");
			System.out.println("--3.修改食品--");
			System.out.println("--4.删除食品--");
			System.out.println("--5.显示所有食品--");
			System.out.println("--0.退出--");
			String num=in.readLine();
			if(num.equals("1"))
			{
				System.out.print("\n请输入食品编号： ");
				String no=in.readLine();
				System.out.print("请输入食品名称： ");
				String name=in.readLine();
				System.out.print("请输入食品价格： ");
				try
				{
					float price=Float.parseFloat(in.readLine());
					Sp sp=new Sp(no,name,price);
					shipin.addsp(sp);
				}catch(Exception e)
				{
					System.out.println("输入有误。");
				}
			}else if(num.equals("2"))
			{
				System.out.print("\n请输入食品编号： ");
				String no=in.readLine();
				shipin.spxx(no);
			}else if(num.equals("3"))
			{
				System.out.print("\n请输入食品编号： ");
				String no=in.readLine();
				System.out.print("请输入食品名称： ");
				String name=in.readLine();
				System.out.print("请输入食品价格： ");
				try
				{
					float price=Float.parseFloat(in.readLine());
					Sp sp=new Sp(no,name,price);
					shipin.spxg(sp);
				}catch(Exception e)
				{
					System.out.println("输入有误。");
				}
			}else if(num.equals("4"))
			{
				System.out.print("\n请输入食品编号： ");
				String no=in.readLine();
				shipin.spsc(no);
			}else if(num.equals("5"))
			{
				shipin.spxs();
			}else if(num.equals("0"))
			{
				System.out.println("程序结束。");
				System.exit(0);
			}else
			{
				System.out.println("输入错误，请重新输入");
			}
		}
	}
}

class spgl
{
	private ArrayList E=null;
	
	spgl()
	{
		E=new ArrayList();
	}
	
	public void addsp(Sp sp)
	{
		for(int i=0;i<E.size();i++)
		{			
			Sp sp0=(Sp)E.get(i);
			if(sp0.getNo().equals(sp.getNo()))
			{
				System.out.println("对不起，已有此编号商品。");
				return;
			}
		}
		E.add(sp);
		System.out.println("食品添加成功。");
	}
	
	public void spxx(String no)
	{
		for(int i=0;i<E.size();i++)
		{
			Sp sp=(Sp)E.get(i);
			if(sp.getNo().equals(no))
			{
				System.out.println("食品编号： "+no);
				System.out.println("食品名称： "+sp.getName());
				System.out.println("食品价格： "+sp.getPrice());
				return;
			}
		}
		System.out.println("对不起，无此商品");
	}
	
	public void spxg(Sp sp)
	{
		int i;
		for(i=0;i<E.size();i++)
		{			
			Sp sp0=(Sp)E.get(i);
			if(sp0.getNo().equals(sp.getNo())){
				break;
			}
		}
		if(i==E.size())
		{
			System.out.println("对不起，无此商品。");
		}else
		{
			E.remove(i);
			E.add(i,sp);
			System.out.println("食品修改成功。");
		}
	}
	
	public void spsc(String no)
	{
		int i;
		for(i=0;i<E.size();i++)
		{
			Sp sp0=(Sp)E.get(i);
			if(sp0.getNo().equals(no))
			{
				break;
			}
		}
		if(i==E.size())
		{
			System.out.println("对不起，无此商品。");
		}else
		{
			E.remove(i);
			System.out.println("食品删除成功。");
		}
	}
	
	public void spxs()
	{
		System.out.println("食品编号\t食品名称\t食品价格");
		for(int i=0;i<E.size();i++)
		{
			Sp sp0=(Sp)E.get(i);
			System.out.println(sp0.getNo()+"\t"+sp0.getName()+"\t"+sp0.getPrice());
		}
	}
}

class Sp 
{
	private String no;
	private String name;
	private float price;
	
	Sp(String no,String name,float price)
	{
		this.no=no;
		this.name=name;
		this.price=price;
	}
	
	public String getNo() 
	{
		return no;
	}
	
	public void setNo(String no) 
	{
		this.no = no;
	}
	
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public float getPrice() 
	{
		return price;
	}
	
	public void setPrice(float price) 
	{
		this.price = price;
	}
}