/*
 * ����package):�������Ϊ�ļ���
 * ���ã�
 * 1��������з������
 * 2�������ṩ�˶�������ռ�
 * ע�⣺
 * 1��������ȫ���ǰ���.����
 * 2������������һ��Ҫ�ڴ���ĵ�һ��
 * 
 * import ��������������Լ������д
 * import��ʹ��ͨ���*���ڵ���˰��е����ж���
 * 
 * ����Ȩ�����η� public protected default private
 * ͬһ����		OK		  OK	   OK      OK
 * ͬһ����		OK		  OK	   OK
 * ����  			OK 		  OK
 * ��ͬ�� 		OK
 * 
 * ��ֻ�ܱ�public��default����Ȩ�����η�����
 * ��һ�����±��ж����˶���ֻ࣬�ܳ���һ��public����
 * ���еĳ�Ա���Ա��������ַ���Ȩ�����η�������
 * 
 * jar����java�����ѹ����
 * �ڵ�ǰĿ¼�����ɰ� javac -d . A.java
 * �ڵ�ǰĿ¼�½���jar�� jar cvf Tool.jar per stu Demp
 * 					  jar cf Tool.jar per stu  
 */

package d_a;

import d_b.Person;
import d_c.*;

public class Test 
{
	public static void main(String[] args)
	{
		Person P=new Person();
		P.develop();
		
		Student S=new Student();
		S.study();
		
		Teacher T=new Teacher();
		T.teach();
	}

}
