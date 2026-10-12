
package engine.patterns.observerPattern;

public interface Subject
{
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void updateAllObserver();
}
