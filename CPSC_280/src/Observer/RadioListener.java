package Observer;

public class RadioListener implements Observer<RadioStation> {
    
    private RadioStation lastStation;
    private String lastSong;

    @Override
    public void update(RadioStation observable) {
        this.lastStation = observable;
        this.lastSong = observable.getSong();
    }

    public RadioStation getLastStation() {
        return lastStation;
    }

    public String getLastSong() {
        return lastSong;
    }
}
