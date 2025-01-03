package org.example.baseJava.steep19.functionalInterface;

public interface FunctionInterfaceTask {

    @FunctionalInterface
    interface FilterCondition {
        boolean resFilt(int number);
    }

    @FunctionalInterface
    interface ArrayTransformer {
        int transform(int element);
    }

    @FunctionalInterface
    interface Condition {
        boolean cond(int number);
    }

    @FunctionalInterface
    interface Aggregator {
        double aggregate(double a, double b);
    }

    @FunctionalInterface
    interface AllCheckCondition {
        boolean result(int number);
    }
}
