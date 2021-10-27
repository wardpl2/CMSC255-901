package Test.Test;

public class Test {
    public static void main(String[] args) {
        System.out.println(max("7", "3"));
    }
    public static int max(String s1, String s2) {
        return Math.max(Integer.parseInt(s1), Integer.parseInt(s2));
    }
}