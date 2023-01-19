package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction function;

    public MapDecorator(SmartArray smartArray, MyFunction function) {
        super(smartArray);
        this.function = function;
        this.smartArray = new BaseArray(mapElements());
    }

    private Object[] mapElements() {
        ArrayList<Object> newArList = new ArrayList<>();
        for (Object obj : smartArray.toArray()) {
            newArList.add(this.function.apply(obj));
        }
        return newArList.toArray();
    }

    @Override
    public Object[] toArray() {
        return this.smartArray.toArray();
    }

    @Override
    public String operationDescription() {
        return "Map every element to other using function";
    }

    @Override
    public int size() {
        return mapElements().length;
    }
}
