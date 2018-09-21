/* Dos 
 * path:主要功能是设置JDK的可执行命令
 * classpath:主要是执行时候起作用，告诉JVM类的所保存的路径
 * set classpath=.	当前路径
 * set classpath=E:\Java\Work
 * ser classpath=.;E:\Java\Work;F:\Kankan
 * 
 * 文档注释	文档标识符
 * javac -d Mydoc -author -version ArrayOperate.java
 */

/**
 * 此类是对数组进行取最值，排序的操作
 * @author Star
 * @version 1.0
 */
public class ArrayOperate 
{
	private ArrayOperate() {}
	
	/**
	 * 取int数组里面的最大值
	 * @param arr 传入一个int数组
	 * @return 返回一个int数值
	 */
	public static int max(int[] arr)
	{
		int max=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(max<arr[i])
			{
				max=arr[i];
			}
		}
		return max;
	}
	
	/**
	 * 取int数组里面的最小值
	 * @param arr 传入一个int数组
	 * @return 返回一个int数值
	 */
	public static int min(int[] arr)
	{
		int min=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			if(min>arr[i])
			{
				min=arr[i];
			}
		}
		return min;
	}
	
	/**
	 * 对传入的int数组进行降序冒泡排序
	 * @param arr 传入一个int数组
	 * @return 返回一个int数组
	 */
	public static int[] bubbleSortMax(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				replaceMax(arr,j,j+1);
			}
		}
		return arr;		
	}
	
	/**
	 * 对传入的int数组进行升序冒泡排序
	 * @param arr 传入一个int数组
	 * @return 返回一个int数组
	 */
	public static int[] bubbleSortMin(int[] arr)
	{
		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<arr.length-1;j++)
			{
				replaceMin(arr,j,j+1);
			}
		}
		return arr;		
	}
	
	/**
	 * 对传入的int数组进行降序选择排序
	 * @param arr 传入一个int数组
	 * @return 返回一个int数组
	 */
	public static int[] selectSortMax(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				replaceMax(arr,i,j);
			}
		}
		return arr;
	}
	
	/**
	 * 对传入的int数组进行升序选择排序
	 * @param arr 传入一个int数组
	 * @return 返回一个int数组
	 */
	public static int[] selectSortMin(int[] arr)
	{
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=i+1;j<arr.length;j++)
			{
				replaceMin(arr,i,j);
			}
		}
		return arr;
	}
	
	private static void replaceMax(int[] arr,int i,int j)
	{
		if(arr[i]<arr[j])
		{
			int k=arr[j];
			arr[j]=arr[i];
			arr[i]=k;
		}
	}
	
	private static void replaceMin(int[] arr,int i,int j)
	{
		if(arr[i]>arr[j])
		{
			int k=arr[j];
			arr[j]=arr[i];
			arr[i]=k;
		}
	}

}
