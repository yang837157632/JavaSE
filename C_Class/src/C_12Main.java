/*
 * 静态应用工具类
 * 每一个应用程序都有共性的功能，可以讲这些功能进行提取，独立封装，以便复用
 * 对象的作用：对象是用来封装数据的
 * 只要这个类里面有非静态的成员时，那对象就必须存在
 */

public class C_12Main 
{
	public static void main(String[] args)
	{
		int[] arr={234,23,345,21,46,78,43,};
		System.out.print("Min	");
		System.out.print(ArrayOperate.min(arr)+"\n原序：\t");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		
		System.out.print("\n降序：\t");
		ArrayOperate.selectSortMax(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		
		System.out.print("\n升序：\t");
		ArrayOperate.selectSortMin(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
	}

}
