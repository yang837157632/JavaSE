import java.util.Scanner;

public class Run 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.println("--������ѧ��������--");
		Student[] stuArr=new Student[in.nextInt()];
		Admin adm=new Admin();
		while(true)
		{
			System.out.println("\n--��ѡ����Ҫִ�еĹ���--");
			System.out.println("--10�����һ��ѧ��--");
			System.out.println("--11������һ��ѧ��--");
			System.out.println("--12�����ݱ�Ÿ���ѧ����Ϣ--");
			System.out.println("--13�����ݱ��ɾ��ѧ��--");
			System.out.println("--14�����ݱ������ѧ���ĸ��ųɼ�--");
			System.out.println("--15������ĳ�ųɼ���������--");
			System.out.println("--16�������ֽܷ�������--");
			System.out.println("--17�����ݱ�Ž�������--");
			System.out.println("--99���˳�ϵͳ--");
			String choice=in.next();
			if(choice.equals("10"))
			{
				System.out.println("\n--ִ�����һ��ѧ���Ĺ���--");
				adm.add(stuArr);
			}else if(choice.equals("11"))
			{
				System.out.println("\n--ִ�в���һ��ѧ���Ĺ���--");
				adm.find(stuArr);
			}else if(choice.equals("12"))
			{
				System.out.println("\n--ִ�и��ݱ�Ÿ���ѧ����Ϣ�Ĺ���--");
				adm.update(stuArr);
			}else if(choice.equals("13"))
			{
				System.out.println("\n--���ݱ��ɾ��ѧ��--");
				adm.delete(stuArr);
			}else if(choice.equals("14"))
			{
				System.out.println("--���ݱ������ѧ���ĸ��ųɼ�--");
				adm.input(stuArr);
			}else if(choice.equals("15"))
			{
				System.out.println("\n--����ĳ�ųɼ���������--");
				adm.sort(stuArr);
			}else if(choice.equals("16"))
			{
				System.out.println("\n--�����ֽܷ�������--");
				adm.sumsort(stuArr);
			}else if(choice.equals("17"))
			{
				System.out.println("\n--���ݱ�Ž�������--");
				adm.numsort(stuArr);
			}else if(choice.equals("99"))
			{
				System.out.println("\n�˳�ϵͳ");
				System.exit(0);
			}else
			{
				System.out.println("\n������������������");
			}
		}
	}

}
