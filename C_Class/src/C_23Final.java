/*
 * final修饰符
 * 1、final可以修饰类，函数，变量（成员变量，局部变量）
 * 2、被final修饰后的类不可以被其他函数继承
 * 3、被final修饰后的函数不可以重写
 * 4、被final修饰后的变量不允许被再次赋值，final在对变量进行修饰时一定要赋值，被final修饰后的变量我们称之为常量
 * 
 * 注意：
 * 常量的命名规范：字母全部都要大写，如果名字由多个单词构成，在单词之间用_分隔开
 */

class C_23Class
{
	final static String SWAN_NAME="天鹅";
}

public class C_23Final 
{
	public static void main(String[] args)
	{
		System.out.println(C_23Class.SWAN_NAME);
	}

}
