import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(int number);
}

interface Subject {
    void registerObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}

class DecimalNumberConverter implements Subject {
    private int decimalNumber;
    private List<Observer> observers = new ArrayList<>();

    public void setDecimalNumber(int decimalNumber) {
        this.decimalNumber = decimalNumber;
        notifyObservers();
    }

    public int getDecimalNumber() {
        return decimalNumber;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(decimalNumber);
        }
    }
}

class HexObserver implements Observer {
    private Subject subject;

    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int number) {
        System.out.println("Hexadecimal: " + Integer.toHexString(number));
    }
}

class OctalObserver implements Observer {
    private Subject subject;

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int number) {
        System.out.println("Octal: " + Integer.toOctalString(number));
    }
}

class BinaryObserver implements Observer {
    private Subject subject;

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.registerObserver(this);
    }

    @Override
    public void update(int number) {
        System.out.println("Binary: " + Integer.toBinaryString(number));
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        DecimalNumberConverter decimalNumberConverter = new DecimalNumberConverter();

        new HexObserver(decimalNumberConverter);
        new OctalObserver(decimalNumberConverter);
        new BinaryObserver(decimalNumberConverter);

        decimalNumberConverter.setDecimalNumber(10);
        System.out.println();

        decimalNumberConverter.setDecimalNumber(25);
        System.out.println();

        decimalNumberConverter.setDecimalNumber(100);
    }
}
