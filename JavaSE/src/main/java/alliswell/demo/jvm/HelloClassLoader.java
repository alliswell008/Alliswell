package alliswell.demo.jvm;

public class HelloClassLoader {
    public void hello() {
        System.out.println("恩，是的，我是由 " + this.getClass().getClassLoader().getClass() + " 加载进来的");
    }
}
