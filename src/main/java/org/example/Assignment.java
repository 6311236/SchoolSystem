package org.example;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Random;

@Getter
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    /**
     * makes an assignment with assignment name and the weight
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     */
    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("A%06d", nextId++);
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.scores = new ArrayList<>();
    }

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

    /**
     * method that generates random scores for all of the students in the assignment
     */
    public void generateRandomScore() {
        Random random = new Random();

        for (int i = 0; i < scores.size(); i++) {
            int category = random.nextInt(11);
            int score;

            if (category == 0) {
                score = random.nextInt(60);
            }
            else if (category >= 1 && category <= 2) {
                score = random.nextInt(10) + 60;
            }
            else if (category >= 3 && category <= 4) {
                score = random.nextInt(10) + 70;
            }
            else if (category >= 5 && category <= 8) {
                score = random.nextInt(10) + 80;
            }
            else {
                score = random.nextInt(11) + 90;
            }

            scores.set(i, score);
        }
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
