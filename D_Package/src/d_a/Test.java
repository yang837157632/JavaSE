/*
 * 包（package):可以理解为文件夹
 * 作用：
 * 1、对类进行分类管理
 * 2、给类提供了多层命名空间
 * 注意：
 * 1、类名的全称是包名.类名
 * 2、定义包的语句一定要在代码的第一行
 * 
 * import 用来导入包，可以简化类的书写
 * import中使用通配符*用于导入此包中的所有对象
 * 
 * 访问权限修饰符 public protected default private
 * 同一个类		OK		  OK	   OK      OK
 * 同一个包		OK		  OK	   OK
 * 子类  			OK 		  OK
 * 不同包 		OK
 * 
 * 类只能被public和default访问权限修饰符修饰
 * 当一个记事本中定义了多个类，只能出现一个public的类
 * 类中的成员可以被以上四种访问权限修饰符所修饰
 * 
 * jar包：java里面的压缩包
 * 在当前目录下生成包 javac -d . A.java
 * 在当前目录下建立jar包 jar cvf Tool.jar per stu Demp
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
