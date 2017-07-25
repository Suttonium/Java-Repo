package ClassNotes;

import java.util.Iterator;

public class RNGesus implements Iterable<Double> {
    @Override
    public Iterator<Double> iterator() {
        return new Iterator<Double>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Double next() {
                return Math.random();
            }
        };
    }

    public static void main(String[] args) {
        RNGesus random = new RNGesus();
        Iterator<Double> iter = random.iterator();
        for (int i = 0; i < 20; i++) {
            System.out.println(iter.next());
        }
        System.out.println("Done");
    }

}
