/* Dos 
 * path:��Ҫ����������JDK�Ŀ�ִ������
 * classpath:��Ҫ��ִ��ʱ�������ã�����JVM����������·��
 * set classpath=.	��ǰ·��
 * set classpath=E:\Java\Work
 * ser classpath=.;E:\Java\Work;F:\Kankan
 * 
 * �ĵ�ע��	�ĵ���ʶ��
 * javac -d Mydoc -author -version ArrayOperate.java
 */

/**
 * �����Ƕ��������ȡ��ֵ������Ĳ���
 * @author Star
 * @version 1.0
 */
public class ArrayOperate 
{
	private ArrayOperate() {}
	
	/**
	 * ȡint������������ֵ
	 * @param arr ����һ��int����
	 * @return ����һ��int��ֵ
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
	 * ȡint�����������Сֵ
	 * @param arr ����һ��int����
	 * @return ����һ��int��ֵ
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
	 * �Դ����int������н���ð������
	 * @param arr ����һ��int����
	 * @return ����һ��int����
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
	 * �Դ����int�����������ð������
	 * @param arr ����һ��int����
	 * @return ����һ��int����
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
	 * �Դ����int������н���ѡ������
	 * @param arr ����һ��int����
	 * @return ����һ��int����
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
	 * �Դ����int�����������ѡ������
	 * @param arr ����һ��int����
	 * @return ����һ��int����
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
