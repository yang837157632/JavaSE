/*
 * ��̬Ӧ�ù�����
 * ÿһ��Ӧ�ó����й��ԵĹ��ܣ����Խ���Щ���ܽ�����ȡ��������װ���Ա㸴��
 * ��������ã�������������װ���ݵ�
 * ֻҪ����������зǾ�̬�ĳ�Աʱ���Ƕ���ͱ������
 */

public class C_12Main 
{
	public static void main(String[] args)
	{
		int[] arr={234,23,345,21,46,78,43,};
		System.out.print("Min	");
		System.out.print(ArrayOperate.min(arr)+"\nԭ��\t");
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		
		System.out.print("\n����\t");
		ArrayOperate.selectSortMax(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
		
		System.out.print("\n����\t");
		ArrayOperate.selectSortMin(arr);
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+"\t");
		}
	}

}
