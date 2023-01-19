package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comparator;

    public SortDecorator(SmartArray smartArray, MyComparator comparator) {
        super(smartArray);
        this.comparator = comparator;
        this.smartArray = new BaseArray(sortComparator());
    }

    private Object[] sortComparator() {
        ArrayList<Object> newArList = new
                ArrayList<Object>(Arrays.asList(smartArray.toArray()));
        newArList.sort(this.comparator);
        return newArList.toArray();
    }


    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Sort elements using comparator";
    }

    @Override
    public int size() {
        return sortComparator().length;
    }
}
