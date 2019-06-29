package alliswell.demo.codeblock;

/**
 * 代码块：
 * 		定义：使用大括号‘{}’括住的代码。
 * 		使用范围：类体中（接口体中不能使用代码块）、方法（或函数）体中
 * 		修饰符：static和无修饰符
 *
 * 静态代码块：
 * 		定义：在java类体中使用static关键字声明的代码块。
 * 		作用：静态块用于初始化类，为类的属性初始化。每个静态代码块只会执行一次。
 * 	注意：
 * 		1 由于JVM在加载类时会执行静态代码块，所以静态代码块先于主方法执行。
 * 		2 静态代码块不能存在于任何方法体内。
 * 		3 静态代码块不能直接访问静态实例变量和实例方法，需要通过类的实例对象来访问。
 *
 * 构造代码块：
 * 		定义：在类中没有加static关键字的代码块。
 * 		作用：给对象统一初始化数据
 * 构造代码块注意点：
 * 		1：java编译器编译java类时，会先将成员属性的声明放到类的前端
 * 		2：成员变量的初始化工作放到构造函数中
 * 		3：如果类中有构造代码块，java编译器在编译时会先将构造代码块中的代码移到构造函数中执行，
 * 		构造函数中原有的代码最后执行
 * 		4：成员属性的初始化和构造代码块的执行顺序是根据原码中的位置执行
 *
 * 	局部代码块：
 * 		定义：在函数(或方法)体中的代码块。
 * 		作用：在方法中，如果要缩短变量的寿命，可以使用
 * 		方法中，某段代码之后，都不再使用某个变量（这个变量有可能是一个很大的Map集合，很占内存），
 * 		则可以将其定义到局部代码块中，及时结束其生命周期，释放空间！
 *
 */
class Code {
	static {
		int a = 1000;
		System.out.println("放在头部的静态代码块:" + a);
	}

	//构造代码块：总是在构造方法执行之前运行
	{
		int x = 100;
		System.out.println("构造代码块:" + x);
	}

	//构造方法
	public Code(){
		System.out.println("无参构造方法:" + "code");
	}

	//构造方法
	public Code(int a){
		System.out.println("有参构造方法:" + "code");
	}

	//构造代码块
	{
		int y = 200;
		System.out.println("构造代码块:" + y);
	}

	//静态代码块
	static {
		int b = 2000;
		System.out.println("放在尾部的静态代码块:" + b);
	}
}

/**
 * 代码块：类中的代码块（静态代码块、构造代码块）和方法中的代码块（局部代码块）
 */
public class CodeBlockDemo {

	// 静态代码块：在类被加载初始化时执行
	static {
		int a = 3000;
		System.out.println("-------1 静态代码块在类加载初始化时就会被执行，所以会先于main（）执行--------");
		System.out.println("有Main方法类中的静态代码块:" + a);
	}

	public static void main(String[] args) throws ClassNotFoundException {

		//局部代码块
		{
			int x = 10;
			System.out.println("局部代码块:" + x);
		}
		// 找不到符号，局部代码块中的变量不能再后续使用，所以局部代码块的作用：缩短变量的生命周期，
		// 在创建大对象时可以使得该对象占用的空间及时被释放
		//System.out.println(x);
		{
			int y = 20;
			System.out.println("局部代码块:" + y);
		}

		System.out.println("-------2 类变量声明时并不会类初始化，所以不会执行该类的静态代码块--------");
		Code code = null;
		System.out.println("code is " + code);
		loadCodeClass();
		System.out.println("-------3 静态代码块只会执行一次--------");
		System.out.println("-------4 两个静态代码块之间是顺序执行，但与其他代码的顺序无关，即使在其他代码之后也会先执行--------");
		System.out.println("-------5 构造代码块总是在构造方法调用之前执行 --------");
		System.out.println("-------6 存在多个构造方法时，无论哪一个构造方法被调用，都会在调用之前执行构造代码块--------");
		// 与第一次new时相比，静态代码块没有再执行
		Code c2 = new Code();
		// 不同的构造方法在调用之前，也执行了构造代码块
		Code c3 = new Code(1);


		System.out.println("-------7 局部代码块与其他代码一起是顺序执行的--------");
		{
			int z = 30;
			System.out.println("局部代码块:" + z);
		}
	}

	/**
	 * 验证静态代码块的执行时机
	 *
	 * 一个类的生命周期分为以下步骤： 1.装载 2.连接（验证、准备、解析） 3.初始化 4.使用（用来创建实例对象） 5.卸载
	 * 类加载过程：1.装载 2.连接（验证、准备、解析） 3.初始化
	 * @throws ClassNotFoundException
	 */
	static void loadCodeClass() throws ClassNotFoundException {
		//仅装载类，不进行初始化，静态代码块未执行
		System.out.println("==类装载，未初始化，未执行静态代码块==");
		Class c1 = Class.forName("alliswell.demo.codeblock.Code", false, CodeBlockDemo.class.getClassLoader());
		System.out.println("==类装载，并初始化，执行了静态代码块==");
		//装载类，并进行初始化，静态代码块执行
		Class c2 = Class.forName("alliswell.demo.codeblock.Code", true, CodeBlockDemo.class.getClassLoader());

		CodeBlockDemo.class.getClassLoader().setClassAssertionStatus("code", true);

		System.out.println("c1 == c2:" + (c1 == c2));
	}
}