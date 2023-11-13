package exp01;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Tester tester = new Tester();
        for(Method method : tester.getClass().getDeclaredMethods()) {
            try {
                System.out.println("   Running method: " + method.getName() + "...");
                method.invoke(tester);
            } catch(Exception e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }
}
