package com.fizbuzz;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Operator {

    private List<Operation> operationList = new ArrayList<>();

    public void addOperation(Operation operation) {
        this.operationList.add(operation);
    }

    public String run(IntStream range) {
        StringBuilder builder= new StringBuilder();
        range.forEach(number -> {
            String message = this.operationList.stream()
                    .filter(operation -> operation.getSpecification().isSatisfiedBy(number))
                    .map(Operation::getMessage)
                    .findFirst()
                    .orElse(String.valueOf(number));
            System.out.print(" "+ message);
            builder.append(" "+message);
        });
        return builder.toString();
    }

}