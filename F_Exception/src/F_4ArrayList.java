/*
 * ��������һЩ������࣬ר������������������ġ�����������Ҫ�����һЩ���ݿ�����ݽṹ�Ĺ��ܡ�
 * ������ĳ��֣�ʹ���ǵĳ������ǿ�󣬸��Ӽ򵥡�
 */

import java.util.*;
class F_4Class
{
	private String name;
	private int no;
	private int score;
	
	F_4Class(String name,int no,int score)
	{
		this.name=name;
		this.no=no;
		this.score=score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public int getNo()
	{
		return no;
	}
	
	public int getScore()
	{
		return score;
	}
}

public class F_4ArrayList 
{
	public static void main(String[] args)
	{
		ArrayList D=new ArrayList();
		System.out.println("ArrayList\t"+D.size());
		F_4Class D1=new F_4Class("Bond",007,98);
		F_4Class D2=new F_4Class("Tom",985,96);
		F_4Class D3=new F_4Class("Richard",211,94);
		F_4Class D4=new F_4Class("Tony",65,84);
		D.add(D1);
		D.add(D2);
		D.add(D3);
		System.out.print("\nBefore ��");
		for(int i=0;i<D.size();i++)
		{
			F_4Class d=(F_4Class)D.get(i);
			System.out.print("\t"+d.getName());			
		}		
		D.remove(1);
		D.add(0,D4);
		F_4Class DD=(F_4Class)D.get(2);
		DD.setName("Steve");
		System.out.print("\nAfter ��");
		for(int i=0;i<D.size();i++)
		{
			F_4Class d=(F_4Class)D.get(i);
			System.out.print("\t"+d.getName());			
		}
	}

}
