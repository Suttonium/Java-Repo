package Observer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class RadioStationTest {
    @Test
    public void testStationHasNoStaticNonPrivateFields() {
        Class<?> station = RadioStation.class;
        for (Field field : station.getFields()) {
            if (!field.isSynthetic()) {
                int modifier = field.getModifiers();
                assertTrue(
                        String.format("field \"%s\" is not private",
                                field.getName()),
                        Modifier.isPrivate(modifier));
                assertFalse(String.format("field \"%s\" is static",
                        field.getName()), Modifier.isStatic(modifier));
            }
        }
    }

    @Test
    public void testListenerHasNoStaticNonPrivateFields() {
        Class<?> station = RadioListener.class;
        for (Field field : station.getFields()) {
            if (!field.isSynthetic()) {
                int modifier = field.getModifiers();
                assertTrue(
                        String.format("field \"%s\" is not private",
                                field.getName()),
                        Modifier.isPrivate(modifier));
                assertFalse(String.format("field \"%s\" is static",
                        field.getName()), Modifier.isStatic(modifier));
            }
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewRadioStationNullName() {
        new RadioStation(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNewRadioStationNoName() {
        new RadioStation(new String(""));
    }

    @Test
    public void testStationIsObservable() {
        assertTrue("incorrect result",
                new RadioStation("98.7 FM WNOR") instanceof Observable<?>);
    }

    @Test
    public void testListenerIsObserver() {
        assertTrue("incorrect result",
                new RadioListener() instanceof Observer<?>);
    }

    @Test
    public void testNewRadioStation() {
        RadioStation a = new RadioStation("96.1 FM WROX 96X");
        assertEquals("incorrect result", "96.1 FM WROX 96X", a.getName());
        assertNull("incorrect result", a.getSong());
        assertFalse("incorrect result", a.hasObservers());
    }

    private static class Mutable<T> {
        public T value;

        public Mutable(T value) {
            this.value = value;
        }
    }

    @Test
    public void testOneListenerOneStation() {
        Mutable<Integer> i = new Mutable<>(0);
        RadioStation a = new RadioStation("96.1 FM WROX 96X");
        RadioListener b = new RadioListener() {
            @Override
            public void update(RadioStation observable) {
                super.update(observable);
                i.value++;
            }
        };
        a.addObserver(b);
        assertTrue("incorrect result", a.hasObservers());

        a.playSong("The Struts - Kiss This");
        assertEquals("incorrect result", 1, (int) i.value);
        assertEquals("incorrect result", a, b.getLastStation());
        assertEquals("incorrect result", "The Struts - Kiss This",
                b.getLastSong());

        a.playSong("Led Zeppelin - Black Dog");
        assertEquals("incorrect result", 2, (int) i.value);
        assertEquals("incorrect result", a, b.getLastStation());
        assertEquals("incorrect result", "Led Zeppelin - Black Dog",
                b.getLastSong());

        assertTrue("incorrect result", a.hasObservers());
        a.removeObserver(b);
        assertFalse("incorrect result", a.hasObservers());
    }

    @Test
    public void testOneListenerSeveralStations() {
        Mutable<Integer> i = new Mutable<>(0);
        RadioStation a1 = new RadioStation("96.1 FM WROX 96X");
        RadioStation a2 = new RadioStation("89.5 FM WHRV NPR");
        RadioStation a3 = new RadioStation("92.1 FM WCDG The Wave");
        RadioListener b = new RadioListener() {
            @Override
            public void update(RadioStation observable) {
                super.update(observable);
                i.value++;
            }
        };
        a1.addObserver(b);
        a2.addObserver(b);
        a3.addObserver(b);

        a1.playSong("The Struts - Kiss This");
        assertEquals("incorrect result", 1, (int) i.value);
        assertEquals("incorrect result", a1, b.getLastStation());
        assertEquals("incorrect result", "The Struts - Kiss This",
                b.getLastSong());

        a2.playSong("Led Zeppelin - Black Dog");
        assertEquals("incorrect result", 2, (int) i.value);
        assertEquals("incorrect result", a2, b.getLastStation());
        assertEquals("incorrect result", "Led Zeppelin - Black Dog",
                b.getLastSong());

        a3.playSong("Coming Out - Diana Ross");
        assertEquals("incorrect result", 3, (int) i.value);
        assertEquals("incorrect result", a3, b.getLastStation());
        assertEquals("incorrect result", "Coming Out - Diana Ross",
                b.getLastSong());
    }

    @Test
    public void testSeveralListenersSeveralStations() {
        Mutable<Integer> i1 = new Mutable<>(0);
        Mutable<Integer> i2 = new Mutable<>(0);
        RadioStation a1 = new RadioStation("96.1 FM WROX 96X");
        RadioStation a2 = new RadioStation("89.5 FM WHRV NPR");
        RadioListener b1 = new RadioListener() {
            @Override
            public void update(RadioStation observable) {
                super.update(observable);
                i1.value++;
            }
        };
        RadioListener b2 = new RadioListener() {
            @Override
            public void update(RadioStation observable) {
                super.update(observable);
                i2.value++;
            }
        };
        a1.addObserver(b1);
        a1.addObserver(b2);
        a2.addObserver(b2);

        a1.playSong("The Beatles - I am a walrus");
        assertEquals("incorrect result", 1, (int) i1.value);
        assertEquals("incorrect result", a1, b1.getLastStation());
        assertEquals("incorrect result", "The Beatles - I am a walrus",
                b1.getLastSong());
        assertEquals("incorrect result", 1, (int) i2.value);
        assertEquals("incorrect result", a1, b2.getLastStation());
        assertEquals("incorrect result", "The Beatles - I am a walrus",
                b2.getLastSong());

        a2.playSong("Journey - Don't stop believing");
        assertEquals("incorrect result", 1, (int) i1.value);
        assertEquals("incorrect result", a1, b1.getLastStation());
        assertEquals("incorrect result", "The Beatles - I am a walrus",
                b1.getLastSong());
        assertEquals("incorrect result", 2, (int) i2.value);
        assertEquals("incorrect result", a2, b2.getLastStation());
        assertEquals("incorrect result", "Journey - Don't stop believing",
                b2.getLastSong());
    }
}
