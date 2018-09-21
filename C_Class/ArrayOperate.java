/*
 * path:主要功能时设置JDK的可执行命令
 * classpath：主要是在执行的时候起作用，告诉JVM类的所保存的路径
 * set classpath=.
 * set classpath=E:\Java\Work
 * set classpath=.;E:\Java\Work;F:\kankan
 * 
 * 文档注释  文档标识符
 * javadoc -d Mydoc -author -version ArrayOperate.java
 */
/**
 * 此类是对数组进行去最值，排序等操作的
 * @author Star
 * @version 1.0
 */
public class ArrayOperate {
	private ArrayOperate(){
		
	}
	/**
	 * 取int数值里面的最大值
	 * @param arr 传入一个int数组
	 * @return 返回一个int数值
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
	 * 去int数组里面的最小值
	 * @param arr 传入一个int数组
	 * @return 返回一个int数值
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
	 * 对传入的int数组进行降序冒泡排序
	 * @param arr 传入一个int数组
	 */
	public static void bubbleSortMax(int[] arr){
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr.length-i;j++){
				replaceMax(arr,j,j+1);
			}
		}
	}
	/**
	 * 对传入的int数组进行升序冒泡排序
	 * @param arr 传入一个int数组
	 */
	public static void bubbleSortMix(int[] arr){
		for(int i=1;i<arr.length;i++){
			for(int j=0;j<arr.length-i;j++){
				replaceMin(arr,j,j+1);
			}
		}
	}
	/**
	 * 对传入的int数组进行降序选择排序
	 * @param arr 传入一个int数组
	 */
	public static void selectSortMax(int[] arr){
		for(int i=0;i<arr.length-1;i++){
			for(int j=i+1;j<arr.length;j++){
				replaceMax(arr,i,j);
			}
		}
	}
	/**
	 * 对传入的int数组进行升序选择排序
	 * @param arr 传入一个int数组
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
