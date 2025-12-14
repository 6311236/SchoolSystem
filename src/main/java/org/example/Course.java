package org.example;

import Util.Util;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;

    /**
     * makes a course with courseName, credits and department
     * @param courseName the course name
     * @param credits the credits
     * @param department the department
     */
    public Course(String courseName, double credits, Department department) {
        if (department != null && department.getDepartmentId() != null) {
            this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        } else {
            this.courseId = String.format("C-XX-%02d", nextId++);
        }
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
    }

    /**
     * checks if the assignment weight is valid by validating that the sum is 100%
     * @return true if the sum of all the weights is 100% and if not false
     */
    public boolean isAssignmentWeightValid() {
        double sum = 0.0;

        for (Assignment assignment : assignments) {
            sum += assignment.getWeight();
        }

        return Math.abs(sum - 100.0) < 0.001;
    }

    /**
     * registers a student in the course
     * @param student the student that will be registered
     * @return true if the registration was succesful and false if he's already registered
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }

        registeredStudents.add(student);

        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * calculates the average for every student with the proper weights
     * @return
     */
    public int[] calcStudentsAverage() {
        if (registeredStudents.isEmpty()) {
            return new int[0];
        }

        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double weightedSum = 0.0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    weightedSum += score * assignment.getWeight() / 100.0;
                }
            }

            averages[i] = (int) Math.round(weightedSum);
        }

        return averages;
    }

    /**
     * adds a assignment in the course
     * @param assignmentName the name if the given assignment
     * @param weight the weight of the given assignment
     * @param maxScore the max score
     * @return true if the assignment was added and if not false
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment assignment = new Assignment(assignmentName, weight);
        assignments.add(assignment);

        for (int i = 0; i < registeredStudents.size(); i++) {
            assignment.getScores().add(null);
        }

        return true;
    }
}
