package Observer;

public interface Observable<T extends Observer<? extends Observable<T>>> {
    void addObserver(T observer);
    void removeObserver(T observer);
    boolean hasObservers();
}
