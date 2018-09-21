/*
 * 有序严谨的指令集称为程序
 * 程序的同时多运行称为进程
 * 程序中不同的执行路径称为线程
 * 多线程编程简单，效率高，易于资源共享
 * 
 * 线程同步
 * 线程同步是指一段程序执行过程中，无论成功还是失败，其它线程都会等待这段程序执行完毕，才会转入其他线程。
 * 这样可以保证程序的完整性和安全性。
 */

class H_1Class extends Thread
{		
	public void run()
	{				//run方法是覆盖的父类方法
		for(int i=0;i<10;i++)
		{
			System.out.println("子函数");
		}
	}
}

public class H_1Extends 
{
	public static void main(String[] args)
	{
		H_1Class A=new H_1Class();
		A.run();				//普通的run调用方法
		System.out.println();
		A.start();				//调用的start方法，程序就去执行run方法，start会开启一个线程，而不是直接调用
		for(int i=0;i<10;i++)
		{
			System.out.println("主函数");
		}
	}
}
