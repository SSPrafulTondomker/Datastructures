package designPatterns;

class MySingletonClass{
    private static MySingletonClass instance;
    private MySingletonClass() {

    }

    static synchronized MySingletonClass getInstance() {
        if (instance == null) {
            instance = new MySingletonClass();
        }
        return instance;
    }

    public void doSomething() {
        System.out.println("I'm single ton class");
    }
}
public class singleton {
    public static void main(String[] args) {
        MySingletonClass mySingletonClass = MySingletonClass.getInstance();
        mySingletonClass.doSomething();
    }
}
