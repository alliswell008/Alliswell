package test;

public class TestA {
    public static void main(String[] args)
    {
        StaticTest.staticFunction();
    }
}
// StaticTest
//public
class StaticTest
{
    // public static void main(String[] args)
    // {
    //     staticFunction();
    // }

    static StaticTest st = new StaticTest();

    static
    {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    public StaticTest()
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


}

// 2
// 3
// a=110,b=0
// 1
// 4
// b=112