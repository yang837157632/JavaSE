import java.util.Scanner;

public class Run 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("--请输入学生的人数--");
		Student[] stuArr=new Student[in.nextInt()];
		Admin adm=new Admin();
		while(true)
		{
			System.out.println("\n--请选择你要执行的功能--");
			System.out.println("--10：添加一个学生--");
			System.out.println("--11：查找一个学生--");
			System.out.println("--12：根据编号更新学生信息--");
			System.out.println("--13：根据编号删除学生--");
			System.out.println("--14：根据编号输入学生的各门成绩--");
			System.out.println("--15：根据某门成绩进行排序--");
			System.out.println("--16：根据总分进行排序--");
			System.out.println("--17：根据编号进行排序--");
			System.out.println("--99：退出系统--");
			String choice=in.next();
			if(choice.equals("10"))
			{
				System.out.println("\n--执行添加一个学生的功能--");
				adm.add(stuArr);
			}else if(choice.equals("11"))
			{
				System.out.println("\n--执行查找一个学生的功能--");
				adm.find(stuArr);
			}else if(choice.equals("12"))
			{
				System.out.println("\n--执行根据编号更新学生信息的功能--");
				adm.update(stuArr);
			}else if(choice.equals("13"))
			{
				System.out.println("\n--根据编号删除学生--");
				adm.delete(stuArr);
			}else if(choice.equals("14"))
			{
				System.out.println("--根据编号输入学生的各门成绩--");
				adm.input(stuArr);
			}else if(choice.equals("15"))
			{
				System.out.println("\n--根据某门成绩进行排序--");
				adm.sort(stuArr);
			}else if(choice.equals("16"))
			{
				System.out.println("\n--根据总分进行排序--");
				adm.sumsort(stuArr);
			}else if(choice.equals("17"))
			{
				System.out.println("\n--根据编号进行排序--");
				adm.numsort(stuArr);
			}else if(choice.equals("99"))
			{
				System.out.println("\n退出系统");
				System.exit(0);
			}else
			{
				System.out.println("\n输入有误，请重新输入");
			}
		}
	}

}
