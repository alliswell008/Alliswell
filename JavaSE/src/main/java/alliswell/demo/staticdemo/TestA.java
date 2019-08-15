package alliswell.demo.staticdemo;

public class TestA {
    public static void main(String[] args)
    {
        StaticTestDemo.staticFunction();
    }
}
// StaticTest
//public
class StaticTestDemo
{
    // public static void main(String[] args)
    // {
    //     staticFunction();
    // }

    static StaticTestDemo st = new StaticTestDemo();

    static
    {
        System.out.println("static 1");
    }

    {
        System.out.println("2");
    }

    public StaticTestDemo()
    {
        System.out.println("3");
        System.out.println("a="+a+",b="+b);
    }

    public static void staticFunction(){
        System.out.println("4");
        System.out.println("b="+b);
    }

    int a=110;
    static int b =112;
    static
    {
        System.out.println("static b="+b);
    }


}

// 2
// 3
// a=110,b=0
// 1
// 4
// b=112