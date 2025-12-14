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
     * @return array of the average score for every student with the proper weights
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

    /**
     * generates a random score for every assignment and student
     */
    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
    }

    /**
     * displays all the scores of the course in a table
     */
    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");

        if (assignments.isEmpty() || registeredStudents.isEmpty()) {
            return;
        }

        int maxNameLength = 20;
        for (Student student : registeredStudents) {
            int nameLength = student.getStudentName().length();
            if (nameLength > maxNameLength) {
                maxNameLength = nameLength;
            }
        }

        System.out.printf("%" + maxNameLength + "s", "");
        for (Assignment assignment : assignments) {
            System.out.printf("%20s", assignment.getAssignmentName());
        }
        System.out.printf("%20s", "Final Score");
        System.out.println();

        int[] studentAverages = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.printf("%" + maxNameLength + "s", student.getStudentName());

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    System.out.printf("%20d", score);
                } else {
                    System.out.printf("%20s", "N/A");
                }
            }

            System.out.printf("%20d", studentAverages[i]);
            System.out.println();
        }

        System.out.printf("%" + maxNameLength + "s", "Average");
        for (Assignment assignment : assignments) {
            double avg = assignment.calcAssignmentAvg();
            System.out.printf("%20.0f", avg);
        }
        System.out.println();
    }

    /**
     * converts a course to a simple string with only the courseId, courseName, credits and departmentName
     * @return the simplifed string version of the course
     */
    public String toSimplifiedString() {
        return courseId + " " + courseName + " (" + credits + " credits, " + department.getDepartmentName() + ")";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Course{");
        result.append("courseId='").append(courseId).append('\'');
        result.append(", courseName='").append(courseName).append('\'');
        result.append(", credits=").append(credits);
        result.append(", departmentName='").append(department.getDepartmentName()).append('\'');
        result.append(", assignments=").append(assignments);
        result.append(", registeredStudents=[");

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            result.append(student.getStudentId()).append(" ").append(student.getStudentName())
                    .append(" (").append(student.getDepartment().getDepartmentName()).append(")");
            if (i < registeredStudents.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        result.append("\nisAssignmentWeightValid=").append(isAssignmentWeightValid());
        result.append("}");
        return result.toString();
    }
}
