/*
 * path:��Ҫ����ʱ����JDK�Ŀ�ִ������
 * classpath����Ҫ����ִ�е�ʱ�������ã�����JVM����������·��
 * set classpath=.
 * set classpath=E:\Java\Work
 * set classpath=.;E:\Java\Work;F:\kankan
 * 
 * �ĵ�ע��  �ĵ���ʶ��
 * javadoc -d Mydoc -author -version ArrayOperate.java
 */
/**
 * �����Ƕ��������ȥ��ֵ������Ȳ�����
 * @author Star
 * @version 1.0
 */
public class ArrayOperate {
	private ArrayOperate(){
		
	}
	/**
	 * ȡint��ֵ��������ֵ
	 * @param arr ����һ��int����
	 * @return ����һ��int��ֵ
	 */
	public static int max(int[] arr){
		int max=arr[0];
		for(int i=1;i<arr.length;i++){
			if(max<arr[i]){
				max=arr[i];
			}
		}
		return max;
	}
	/**
	 * ȥint�����������Сֵ
	 * @param arr ����һ��int����
	 * @return ����һ��int��ֵ
	 */
	public static int min(int[] arr){
		int min=arr[0];
		for(int i=0;i<arr.length;i++){
			if(min<arr[i]){
				min=arr[i];
			}
		}
		return min;
	}
	/**
	 * �Դ����int������н���ð������
	 * @param arr ����һ��int����
	 */
	public static void bubbleSortMax(int[] arr){
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr.length-i;j++){
				replaceMax(arr,j,j+1);
			}
		}
	}
	/**
	 * �Դ����int�����������ð������
	 * @param arr ����һ��int����
	 */
	public static void bubbleSortMix(int[] arr){
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr.length-i;j++){
				replaceMin(arr,j,j+1);
			}
		}
	}
	/**
	 * �Դ����int������н���ѡ������
	 * @param arr ����һ��int����
	 */
	public static void selectSortMax(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				replaceMax(arr,i,j);
			}
		}
	}
	/**
	 * �Դ����int�����������ѡ������
	 * @param arr ����һ��int����
	 */
	public static void selectSortMin(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				replaceMin(arr,i,j);
			}
		}
	}
	
	private  static void replaceMax(int[] arr,int i,int j){
		if(arr[i]<arr[j]){
			int c=arr[i];
			arr[i]=arr[j];
			arr[j]=c;
		}
	}
	
	private  static void replaceMin(int[] arr,int i,int j){
		if(arr[i]>arr[j]){
			int c=arr[i];
			arr[i]=arr[j];
			arr[j]=c;
		}
	}

}
