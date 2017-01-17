/**
 * @Title: Grabage
 * @Package test
 * @Description: TODO(用一句话来说明)
 * @author alliswell008
 * @date 2016/12/9 15:39
 * @version V1.0
 * Update Logs:
 * ****************************************************
 * Name:
 * Date:
 * Description:
 * *****************************************************
 */
package test;

/**
 * @author alliswell008
 * @ClassName: Grabage
 * @Description: TODO(用一句话来说明)
 * @date 2016/12/9 15:39
 */
public class Grabage {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Usage: \n" +
                    "java Grabage before\n or:\n" +
                    "java Grabage after");
            return;
        }
        while(!Chair.f) {
            new Chair();
            new String("To take up space");
        }
        System.out.println("After all Chairs have been created:\n" +
                "total created = " + Chair.created +
                ", total finalized = " + Chair.finalized);
        if(args[0].equals("before")) {
            System.out.println("gc():");
            System.gc();
            System.out.println("runFinalization():");
            System.runFinalization();
        }
        System.out.println("bye!");
        if(args[0].equals("after"))
            System.runFinalizersOnExit(true);
    }
}

class Chair {
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;
    Chair() {
        i = ++created;
        if(created == 47)
            System.out.println("Created 47");
    }

    protected void finalized() {
        if(!gcrun) {
            gcrun = true;
            System.out.println("Beginning to finalize after" +
                    created + " Chairs have been created");
        }
        if(i == 47) {
            System.out.println("Finalizing Chair #47, " +
                    "Setting flag to stop Chair creation");
            f = true;
        }
        finalized++;
        if(finalized >= created)
            System.out.println("All " + finalized + "finalized");
    }
}