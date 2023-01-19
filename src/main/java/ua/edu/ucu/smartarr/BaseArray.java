package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    private Object[] array;

    public BaseArray(Object[] elements) {
        this.array = elements;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }

    @Override
    public String operationDescription() {
        return null;
    }

    @Override
    public int size() {
        return this.array.length;
    }
}
