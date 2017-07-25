package ClassNotes;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Bubble implements Iterable<Integer> {
    private List<Integer> list = new LinkedList<Integer>();

    public void add(Integer... a) {
        list.addAll(Arrays.asList(a));
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < list.size();
            }

            @Override
            public Integer next() {
                return list.get(index++);
            }
        };
    }

    public static void main(String[] args) {
        Bubble b = new Bubble();
        b.add(1, 42, 6, -9, 30);

        Iterator<Integer> iter = b.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        for (Integer i : b) {
            System.out.println(i);
        }
    }

}
