package ua.edu.ucu;

import ua.edu.ucu.functions.MyComparator;
import ua.edu.ucu.functions.MyFunction;
import ua.edu.ucu.functions.MyPredicate;
import ua.edu.ucu.smartarr.*;

import java.util.Arrays;

public class SmartArrayApp {

    public static Integer[]
    filterPositiveIntegersSortAndMultiplyBy2(Integer[] integers) {

        MyPredicate pr = new MyPredicate() {
            @Override
            public boolean test(Object t) {
                return ((Integer) t) > 0;
            }
        };


        MyComparator cmp = new MyComparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Integer) o1) - ((Integer) o2);
            }
        };

        MyFunction func = new MyFunction() {
            @Override
            public Object apply(Object t) {
                return 2 * ((Integer) t);
            }
        };

        // Input: [-1, 2, 0, 1, -5, 3]
        SmartArray sa = new BaseArray(integers);

        sa = new FilterDecorator(sa, pr); // Result: [2, 1, 3];
        sa = new SortDecorator(sa, cmp); // Result: [1, 2, 3]
        sa = new MapDecorator(sa, func); // Result: [2, 4, 6]

        // Alternative
//        sa = new MapDecorator(
//                    new SortDecorator(
//                        new FilterDecorator(sa, pr),
//                    cmp),
//                func);
        Object[] result = sa.toArray();
        return Arrays.copyOf(result, result.length, Integer[].class);
    }

    public static String[]
    findDistinctStudentNamesFrom2ndYearWithGPAgt4AndOrderedBySurname(Student[] students) {

        // Hint: to convert Object[] to String[] - use the following code
        //Object[] result = studentSmartArray.toArray();
        //return Arrays.copyOf(result, result.length, String[].class);

        MyPredicate studPredicate = new MyPredicate() {
            @Override
            public boolean test(Object student) {
                return ((Student) student).getGPA() >= 4 &&
                        ((Student) student).getYear() == 2;
            }
        };

        MyComparator studComparator = new MyComparator() {
            @Override
            public int compare(Object stud1, Object stud2) {
                return ((Student) stud1).getSurname().compareTo
                        (((Student) stud2).getSurname());
            }
        };

        MyFunction stucFunction = new MyFunction() {
            @Override
            public Object apply(Object stud) {
                return ((Student) stud).getSurname() + " " +
                        ((Student) stud).getName();
            }
        };

        SmartArray studentSmartArray = new BaseArray(students);
        studentSmartArray = new FilterDecorator(studentSmartArray,
                studPredicate);
        studentSmartArray = new SortDecorator(studentSmartArray,
                studComparator);
        studentSmartArray = new MapDecorator(studentSmartArray,
                stucFunction);
        Object[] result = studentSmartArray.toArray();
        String[] studSmartArray = Arrays.copyOf(result,
                result.length, String[].class);
        DistinctDecorator finArray = new DistinctDecorator(new
                BaseArray(studSmartArray));
        return Arrays.copyOf(finArray.toArray(),
                finArray.toArray().length, String[].class);
    }
}
