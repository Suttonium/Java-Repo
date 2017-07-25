package Singleton;

public class Thing {
    private static Thing instance = null;
    // initialized later on instead

    private Thing() {
    }

    public static Thing getInstance() {
        if (instance == null) {
            instance = new Thing();
            // the lazy/efficient approach
        }
        return instance;
    }

    public void doSomething() {
    }

    public static void main(String[] args) {
        Thing aThing = Thing.getInstance();
        aThing.doSomething();
    }
}
