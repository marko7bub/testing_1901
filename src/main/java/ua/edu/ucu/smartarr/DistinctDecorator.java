package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
        this.smartArray = new BaseArray(removeDuplicates());
    }

    private Object[] removeDuplicates() {
        ArrayList<Object> newArList =
                new ArrayList<Object>(Arrays.asList(smartArray.toArray()));
        int counter = 0;
        for (Object obj : smartArray.toArray()) {
            for (int i = counter + 1; i < smartArray.size(); i++) {
                if (obj.equals(smartArray.toArray()[i])) {
                    newArList.set(i, "need to remove");
                }
            }
            counter += 1;
        }
        newArList.removeAll(Collections.singleton("need to remove"));
        Object[] finArray = newArList.toArray();
        return finArray;
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Removing duplicates from array";
    }

    @Override
    public int size() {
        return removeDuplicates().length;
    }
}
