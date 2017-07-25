package Singleton;

public class SingletonEagerExample {

    // Static member holds only one instance of the
    // SingletonExample class
    private static SingletonEagerExample singletonInstance = new SingletonEagerExample();

    // SingletonExample prevents any other class from instantiating
    private SingletonEagerExample() {

    }

    // Providing Global point of access
    public static SingletonEagerExample getSingletonInstance() {
        return singletonInstance;
    }
}