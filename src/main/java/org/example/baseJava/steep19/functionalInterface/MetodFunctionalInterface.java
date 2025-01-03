package org.example.baseJava.steep19.functionalInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;


public class MetodFunctionalInterface implements FunctionInterfaceTask{

    public int[] filterArray(int[] numbers, FilterCondition condition) {
        List<Integer> filteredList = new ArrayList<>();

        for (int number : numbers) {
            if (condition.resFilt(number)) {
                filteredList.add(number);
            }
        }

        int[] result = new int[filteredList.size()];
        for (int i = 0; i < filteredList.size(); i++) {
            result[i] = filteredList.get(i);
        }

        return result;
    }

    public int[] transformArray(int[] array, ArrayTransformer transformer) {
        int[] transformedArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            transformedArray[i] = transformer.transform(array[i]);
        }

        return transformedArray;
    }

    public static int findMax(int[] array, Condition condition) {
        OptionalInt max = OptionalInt.empty();

        for (int number : array) {
            if (condition.cond(number)) {
                if (max.isEmpty() || number > max.getAsInt()) {
                    max = OptionalInt.of(number);
                }
            }
        }

        if (max.isPresent()) {
            return max.getAsInt();
        } else {
            throw new IllegalArgumentException("Нет элементов");
        }
    }

    public static double aggregateArray(double[] array, Aggregator aggregator, double initialValue) {
        double result = initialValue;  // Начальное значение для агрегации

        for (double number : array) {
            result = aggregator.aggregate(result, number);
        }

        return result;
    }

    public static boolean allCheck(int[] array, AllCheckCondition condition) {
        for (int number : array) {
            if (!condition.result(number)) {
                return false;
            }
        }
        return true;
    }
}
