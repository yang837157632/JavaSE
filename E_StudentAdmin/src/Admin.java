import java.util.Scanner;

public class Admin 
{
	Scanner in=new Scanner(System.in);
	
	//���ѧ����Ϣ
	public void hprint()
	{
		System.out.println("\t���\t����\t����\tJava\tC#\tHtml\tSql\tSum\tAve");
	}
	
	public void sprint(Student[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]!=null)
			{
				System.out.println(arr[i]);
			}
		}
	}
	
	//ȷ��ѧ���ı��
	public int index(Student[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]==null)
			{
				return i;
			}
		}
		return -1;
	}
	
	//ȷ��ѧ���Ƿ����
	public int exist(Student[] arr)
	{
		System.out.print("������ѧ���ı�ţ� ");
		int i=in.nextInt();
		if(i>arr.length)
		{
			System.out.println("��ų�����Χ");
			return -1;
		}
		if(arr[i-1]==null)
		{
			System.out.println("�޴˱�ŵ�ѧ��");
			return -1;
		}
		return i;
	}
	
	//���һ��ѧ��
	public void add(Student[] arr)
	{
		int no=this.index(arr);
		if(no==-1)
		{
			System.out.println("��������");
			return;
		}
		Student S=new Student();
		S.setNo(no+1);
		System.out.print("������ѧ���������� ");
		S.setName(in.next());
		System.out.print("������ѧ�������䣺 ");
		if(!in.hasNextInt()){
			System.out.println("������ĸ�ʽ����");
			return;
		}
		S.setAge(in.nextInt());
		arr[no]=S;
		this.hprint();
		this.sprint(arr);				
	}
	
	//����һ��ѧ��
	public void find(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1)
		{
			System.out.println("û�����ѧ��");
			return;
		}
		this.hprint();
		System.out.println(arr[i-1]);		
	}
	
	//���ݱ�Ÿ���ѧ����Ϣ
	public void update(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1)
		{
			System.out.println("û�����ѧ��");
			return;
		}
		System.out.print("������ѧ���������� ");
		arr[i-1].setName(in.next());
		System.out.print("������ѧ�������䣺 ");
		arr[i-1].setAge(in.nextInt());
		this.hprint();
		this.sprint(arr);
	}
	
	//����ѧ�����ɾ��ѧ��
	public void delete(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1){
			System.out.println("û�����ѧ��");
			return;
		}
		arr[i-1]=null;
		this.hprint();
		this.sprint(arr);
	}
	
	//���ݱ������ѧ���ĸ��ųɼ�
	public void input(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1)
		{
			System.out.println("û�����ѧ��");
			return;
		}
		System.out.print("������"+arr[i-1].getName()+"Java�ɼ�: ");
		arr[i-1].setJava(in.nextInt());
		System.out.print("������"+arr[i-1].getName()+"C#�ɼ�: ");
		arr[i-1].setC_shar(in.nextInt());
		System.out.print("������"+arr[i-1].getName()+"Html�ɼ�: ");
		arr[i-1].setHtml(in.nextInt());
		System.out.print("������"+arr[i-1].getName()+"Sql�ɼ�: ");
		arr[i-1].setSql(in.nextInt());
		arr[i-1].setSum();
		arr[i-1].setAve();
		this.hprint();
		this.sprint(arr);
	}
	
	//����ĳ�ųɼ���������
	public void sort(Student[] arr)
	{
		System.out.println("��ȷ���γ̣�1.Java\t2.C#\t3.Html\t4.Sql");
		String num=in.next();
		Student S=new Student();
		if(num.equals("1"))
		{
			for(int i=0;i<arr.length-1;i++)
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if((arr[i]!=null)&&(arr[j]!=null))
					{
						if(arr[i].getJava()<arr[j].getJava())
						{
							S=arr[i];
							arr[i]=arr[j];
							arr[j]=S;
						}
					}
				}
			}
		}else if(num.equals("2"))
		{
			for(int i=0;i<arr.length-1;i++)
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if((arr[i]!=null)&&(arr[j]!=null))
					{
						if(arr[i].getC_shar()<arr[j].getC_shar())
						{
							S=arr[i];
							arr[i]=arr[j];
							arr[j]=S;
						}
					}
				}
			}

		}else if(num.equals("3"))
		{
			for(int i=0;i<arr.length-1;i++)
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if((arr[i]!=null)&&(arr[j]!=null))
					{
						if(arr[i].getHtml()<arr[j].getHtml())
						{
							S=arr[i];
							arr[i]=arr[j];
							arr[j]=S;
						}
					}
				}
			}
		}else if(num.equals("4"))
		{
			for(int i=0;i<arr.length-1;i++)
			{
				for(int j=i+1;j<arr.length;j++)
				{
					if((arr[i]!=null)&&(arr[j]!=null))
					{
						if(arr[i].getSql()<arr[j].getSql())
						{
							S=arr[i];
							arr[i]=arr[j];
							arr[j]=S;
						}
					}
				}
			}
		}else
		{
			System.out.println("�γ̱����������");
		}
		this.hprint();
		this.sprint(arr);
	}
	
	//�����ֽܷ�������
	public void sumsort(Student[] arr)
	{
		Student S=new Student();
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if((arr[i]!=null)&&(arr[j]!=null))
				{
					if(arr[i].getSum()<arr[j].getSum())
					{
						S=arr[i];
						arr[i]=arr[j];
						arr[j]=S;
					}
				}
			}
		}
		this.hprint();
		this.sprint(arr);
	}
	
	//���ݱ�Ž�������
	public void numsort(Student[] arr)
	{
		Student S=new Student();
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				if((arr[i]!=null)&&(arr[j]!=null))
				{
					{
						if(arr[i].getNo()<arr[j].getNo())
						{
							S=arr[i];
							arr[i]=arr[j];
							arr[j]=S;
						}
					}
				}
			}
		}
		this.hprint();
		this.sprint(arr);
	}

}
