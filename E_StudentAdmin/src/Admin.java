import java.util.Scanner;

public class Admin 
{
	Scanner in=new Scanner(System.in);
	
	//输出学生信息
	public void hprint()
	{
		System.out.println("\t编号\t姓名\t年龄\tJava\tC#\tHtml\tSql\tSum\tAve");
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
	
	//确定学生的编号
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
	
	//确定学生是否存在
	public int exist(Student[] arr)
	{
		System.out.print("请输入学生的编号： ");
		int i=in.nextInt();
		if(i>arr.length)
		{
			System.out.println("编号超出范围");
			return -1;
		}
		if(arr[i-1]==null)
		{
			System.out.println("无此编号的学生");
			return -1;
		}
		return i;
	}
	
	//添加一个学生
	public void add(Student[] arr)
	{
		int no=this.index(arr);
		if(no==-1)
		{
			System.out.println("人数已满");
			return;
		}
		Student S=new Student();
		S.setNo(no+1);
		System.out.print("请输入学生的姓名： ");
		S.setName(in.next());
		System.out.print("请输入学生的年龄： ");
		if(!in.hasNextInt()){
			System.out.println("你输入的格式有误");
			return;
		}
		S.setAge(in.nextInt());
		arr[no]=S;
		this.hprint();
		this.sprint(arr);				
	}
	
	//查找一个学生
	public void find(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1)
		{
			System.out.println("没有这个学生");
			return;
		}
		this.hprint();
		System.out.println(arr[i-1]);		
	}
	
	//根据编号更新学生信息
	public void update(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1)
		{
			System.out.println("没有这个学生");
			return;
		}
		System.out.print("请输入学生的姓名： ");
		arr[i-1].setName(in.next());
		System.out.print("请输入学生的年龄： ");
		arr[i-1].setAge(in.nextInt());
		this.hprint();
		this.sprint(arr);
	}
	
	//根据学生编号删除学生
	public void delete(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1){
			System.out.println("没有这个学生");
			return;
		}
		arr[i-1]=null;
		this.hprint();
		this.sprint(arr);
	}
	
	//根据编号输入学生的各门成绩
	public void input(Student[] arr)
	{
		int i=this.exist(arr);
		if(i==-1)
		{
			System.out.println("没有这个学生");
			return;
		}
		System.out.print("请输入"+arr[i-1].getName()+"Java成绩: ");
		arr[i-1].setJava(in.nextInt());
		System.out.print("请输入"+arr[i-1].getName()+"C#成绩: ");
		arr[i-1].setC_shar(in.nextInt());
		System.out.print("请输入"+arr[i-1].getName()+"Html成绩: ");
		arr[i-1].setHtml(in.nextInt());
		System.out.print("请输入"+arr[i-1].getName()+"Sql成绩: ");
		arr[i-1].setSql(in.nextInt());
		arr[i-1].setSum();
		arr[i-1].setAve();
		this.hprint();
		this.sprint(arr);
	}
	
	//根据某门成绩进行排序
	public void sort(Student[] arr)
	{
		System.out.println("请确定课程：1.Java\t2.C#\t3.Html\t4.Sql");
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
			System.out.println("课程编号输入有误");
		}
		this.hprint();
		this.sprint(arr);
	}
	
	//根据总分进行排序
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
	
	//根据编号进行排序
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
