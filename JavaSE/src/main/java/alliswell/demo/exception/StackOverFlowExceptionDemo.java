package alliswell.demo.exception;

/**
 * 递归导致栈溢出
 */
public class StackOverFlowExceptionDemo {
    public static void main(String[] args) {
//        String[] a = {"a1","a2","a3","b3","c","b","33","33"};
//        boolean b = new Taaa().fun(0, a);
//        System.out.println(b);
        System.out.println(new StackOverFlowExceptionDemo().fib(100000000));
    }

    public boolean fun(int n,String[] a){
        boolean b = false;
        if(n == a.length){
            b = true;
        }else{
            for(int i = n; i < a.length-1; i++){
                System.out.println(n+"    "+(i+1));
                if(a[n].equals(a[i+1])){
                    return false;
                }
            }
            n++;
            fun(n,a);
        }
        return b;
    }

    long fib(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
