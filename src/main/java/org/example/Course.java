package org.example;

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
}
