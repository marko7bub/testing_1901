package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate predicate;


    public FilterDecorator(SmartArray smartArray, MyPredicate myPredicate) {
        super(smartArray);
        this.predicate = myPredicate;
        this.smartArray = new BaseArray(testPredicate());
    }

    private Object[] testPredicate() {
        ArrayList<Object> newArList = new ArrayList<>();
        for (Object obj : smartArray.toArray()) {
            if (predicate.test(obj)) {
                newArList.add(obj);
            }
        }
        return newArList.toArray();
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Testing predicate on all elements of array";
    }

    @Override
    public int size() {
        return testPredicate().length;
    }
}
