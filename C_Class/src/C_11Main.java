/*
 * main ����������������
 * 1��public ���������η��������ģ����������߸ú�������Ȩ��������
 * 2��static ����������������ļ��ؾ��Ѿ�������
 * 3��void ����������û�о���ķ���ֵ
 * 4��main main����java�йؼ��֣�����һ������ĵ��ʣ����ܹ���JVM��java���������ʶ��
 * 5��String[] args �����Ĳ���������������һ���ַ������飬�������Ԫ�����ַ���
 */

public class C_11Main 
{
	public static void main(String[] args)
	{
		int[] arr={12,43,34,76,63,54,23,56};
		System.out.print("Max	");
		System.out.print(ArrayOperate.max(arr)+"\nԭ��\t");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		
		System.out.print("\n����\t");
		ArrayOperate.bubbleSortMax(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		
		System.out.print("\n����\t");
		ArrayOperate.bubbleSortMin(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
	}

}
