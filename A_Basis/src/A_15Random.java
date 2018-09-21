import java.util.Random;

public class A_15Random 
{
	public static void main(String[] args)
	{
		Random R=new Random();
		int num1=R.nextInt(11);			//0-10之间11个整数
		System.out.println("Random number of first method is "+num1);
//		nextBoolean()
//		nextDouble()		[0,1)
//		nextFloat()			[0,1)	
//		nextGaussian()		n=0,σ=1
//		nextInt()
//		nextLong()
		
		double num2=Math.random()*10;	//[0,10) 包括小数
		System.out.println("Random number of second method is "+num2);		
	}
	
}
