package Singleton;

public class SingletonLazyExample {

    // Static member holds only one instance of the
    // SingletonExample class
    private static SingletonLazyExample singletonInstance;

    // SingletonExample prevents any other class from instantiating
    private SingletonLazyExample() {

    }

    // Providing Global point of access
    public static SingletonLazyExample getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new SingletonLazyExample();
        }
        return singletonInstance;
    }
}