package Observer;

public interface Observer<T extends Observable<? extends Observer<T>>> {
    void update(T observable);
}
