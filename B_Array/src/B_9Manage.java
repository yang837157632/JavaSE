import java.util.*;
public class B_9Manage 
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		System.out.print("Please input the number of courses: ");
		int courseNum=in.nextInt();
		String[] course=new String[courseNum];
		System.out.print("Please input the number of people: ");
		int peopleNum=in.nextInt();
		int[] sum=new int[peopleNum];
		int[] ave=new int[peopleNum];
		int[][] num=new int[peopleNum][courseNum];
		String[] name=new String[peopleNum];
		String[] S=new String[peopleNum];
		for(int i=0;i<course.length;i++)
		{
			System.out.print("please input the name of the "+(i+1)+" course: ");
			course[i]=in.next();
		}
		for(int i=0;i<num.length;i++)
		{
			System.out.print("Please input the "+(i+1)+" student's name: ");
			name[i]=in.next();
			S[i]=name[i];
			sum[i]=0;
			for(int j=0;j<num[i].length;j++)
			{
				System.out.print("please input "+name[i]+"'s "+course[j]+"'s score: ");
				num[i][j]=in.nextInt();
				sum[i]+=num[i][j];
				S[i]+="\t"+num[i][j];
			}
			ave[i]=sum[i]/courseNum;
			S[i]=S[i]+"\t"+sum[i]+"\t"+ave[i];
		}
		for(int i=0;i<sum.length-1;i++)
		{
			for(int j=i+1;j<sum.length;j++)
			{
				if(sum[i]<sum[j]){
					int a=sum[i];
					sum[i]=sum[j];
					sum[j]=a;
					String b=S[i];
					S[i]=S[j];
					S[j]=b;
				}
			}
		}
		System.out.print("Name\t");
		for(int i=0;i<course.length;i++)
		{
			System.out.print(course[i]+"\t");
		}
		System.out.println("Sum\tAve\tRank");
		for(int i=0;i<S.length;i++)
		{
			System.out.println(S[i]+"\t"+(i+1));
		}
	}

}
