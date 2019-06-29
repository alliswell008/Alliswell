package test;

public class Null {
    public static void hello() {
        System.out.println("hello");
    }

    public static void main(String[] args) {
        ((Null)null).hello();
        getCustomerInfo();
    }

    public static void getCustomerInfo() {
        try {
// do something that may cause an Exception
            throw new java.io.IOException();
        } catch (java.io.FileNotFoundException ex) {
            System.out.println("FileNotFoundException!");
        } catch (java.io.IOException ex) {
            System.out.println("IOException!");
        } catch (java.lang.Exception ex) {
            System.out.println("Exception!");
        }
    }
}

