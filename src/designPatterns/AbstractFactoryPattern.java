package designPatterns;

abstract class Client {
    abstract void doSomething();
}

class AndroidClient extends Client {
     void doSomething() {
         System.out.println("I'm android client!!!");
     }

}

class IosClient extends Client {
    void doSomething() {
        System.out.println("I'm ios client!!!");
    }
}

class WebClient extends Client {
    void doSomething() {
        System.out.println("I'm webclient client!!!");
    }
}

enum ClientType {
    Android,
    Ios,
    Web;
}
class ClientFactory {
    public static Client getClient(ClientType clientType) {
        return switch (clientType) {
            case Android -> new AndroidClient();
            case Ios -> new IosClient();
            default -> new WebClient();
        };
    }
}
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Client client = ClientFactory.getClient(ClientType.Android);
        client.doSomething();
    }
}
