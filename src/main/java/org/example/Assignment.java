package org.example;

import lombok.Getter;

import java.util.ArrayList;

@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    /**
     * calculates the average for the given assignment
     * @return the average scire of the assignment or 0 if there are no scores
     */
    public double calcAssignmentAvg() {
        if (scores.isEmpty()) {
            return 0.0;
        }

        int sum = 0;
        int count = 0;

        for (Integer score : scores) {
            if (score != null) {
                sum += score;
                count++;
            }
        }

        if (count == 0) {
            return 0.0;
        }

        return (double) sum / count;
    }
}
