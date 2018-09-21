/*
 * HashMap ��ֵ�����ظ�ʱ�ɸ���
 * 
 * List��������Map�����������
 * ��ֵ����Ψһ��ʶĳһ�����ֵ��Ϊ��ֵ��
 * ע�⣺��ֵ��Ϊ��Ψһ��ʶ�����������ӵ����ԣ�һ����Ҫ�����ﱾ�������������ֵ��
 * Listû�м�ֵ��Map�м�ֵ��
 * 
 * ArrayList��Vector��������HashMap��Hashtable��������ͬ�������ǣ�
 * ArrayList��HashMap�����߳��첽�ģ��������ǵ��ص���Ч�ʸߵ��ǰ�ȫ�Ե͡�
 * Vector��Hashtable�����߳�ͬ���ģ��������ǵ��ص���Ч�ʵ͵��ǰ�ȫ�Ըߡ�
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
			System.out.println("û�б��Ϊ 001 ��ʳƷ");
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
