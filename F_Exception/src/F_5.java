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
			System.out.println("\n--�밴��ʾѡ�����¹���--");
			System.out.println("--1.���ʳƷ--");
			System.out.println("--2.����ʳƷ--");
			System.out.println("--3.�޸�ʳƷ--");
			System.out.println("--4.ɾ��ʳƷ--");
			System.out.println("--5.��ʾ����ʳƷ--");
			System.out.println("--0.�˳�--");
			String num=in.readLine();
			if(num.equals("1"))
			{
				System.out.print("\n������ʳƷ��ţ� ");
				String no=in.readLine();
				System.out.print("������ʳƷ���ƣ� ");
				String name=in.readLine();
				System.out.print("������ʳƷ�۸� ");
				try
				{
					float price=Float.parseFloat(in.readLine());
					Sp sp=new Sp(no,name,price);
					shipin.addsp(sp);
				}catch(Exception e)
				{
					System.out.println("��������");
				}
			}else if(num.equals("2"))
			{
				System.out.print("\n������ʳƷ��ţ� ");
				String no=in.readLine();
				shipin.spxx(no);
			}else if(num.equals("3"))
			{
				System.out.print("\n������ʳƷ��ţ� ");
				String no=in.readLine();
				System.out.print("������ʳƷ���ƣ� ");
				String name=in.readLine();
				System.out.print("������ʳƷ�۸� ");
				try
				{
					float price=Float.parseFloat(in.readLine());
					Sp sp=new Sp(no,name,price);
					shipin.spxg(sp);
				}catch(Exception e)
				{
					System.out.println("��������");
				}
			}else if(num.equals("4"))
			{
				System.out.print("\n������ʳƷ��ţ� ");
				String no=in.readLine();
				shipin.spsc(no);
			}else if(num.equals("5"))
			{
				shipin.spxs();
			}else if(num.equals("0"))
			{
				System.out.println("���������");
				System.exit(0);
			}else
			{
				System.out.println("�����������������");
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
				System.out.println("�Բ������д˱����Ʒ��");
				return;
			}
		}
		E.add(sp);
		System.out.println("ʳƷ��ӳɹ���");
	}
	
	public void spxx(String no)
	{
		for(int i=0;i<E.size();i++)
		{
			Sp sp=(Sp)E.get(i);
			if(sp.getNo().equals(no))
			{
				System.out.println("ʳƷ��ţ� "+no);
				System.out.println("ʳƷ���ƣ� "+sp.getName());
				System.out.println("ʳƷ�۸� "+sp.getPrice());
				return;
			}
		}
		System.out.println("�Բ����޴���Ʒ");
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
			System.out.println("�Բ����޴���Ʒ��");
		}else
		{
			E.remove(i);
			E.add(i,sp);
			System.out.println("ʳƷ�޸ĳɹ���");
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
			System.out.println("�Բ����޴���Ʒ��");
		}else
		{
			E.remove(i);
			System.out.println("ʳƷɾ���ɹ���");
		}
	}
	
	public void spxs()
	{
		System.out.println("ʳƷ���\tʳƷ����\tʳƷ�۸�");
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