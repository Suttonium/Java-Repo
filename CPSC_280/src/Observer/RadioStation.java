package Observer;

import java.util.ArrayList;
import java.util.List;

public class RadioStation implements Observable<RadioListener> {
    private String name;
    private String song;
    private List<RadioListener> observers;

    public RadioStation(String name) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        observers = new ArrayList<RadioListener>();
    }

    @Override
    public void addObserver(RadioListener observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(RadioListener observer) {
        observers.remove(observer);
    }

    @Override
    public boolean hasObservers() {
        return observers.size() > 0;
    }

    private void notifyObservers() {
        for (RadioListener observer : observers) {
            observer.update(this);
        }
    }

    public String getName() {
        return name;
    }

    public String getSong() {
        return song;
    }

    public void playSong(String song) {
        this.song = song;
        notifyObservers();
    }

}
