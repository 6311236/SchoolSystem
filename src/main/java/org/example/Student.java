package org.example;

import Util.Util;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@EqualsAndHashCode
@Getter
@Setter
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    /**
     * make a student with name, gender, address and department given
     * @param studentName the name of the student
     * @param gender the gender of the student
     * @param address the address of the student
     * @param department the department of the student
     */
    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%06d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * registers a course for a student
     * @param course that will be registered
     * @return true if the student succesfully registered and false otherwise
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }

        registeredCourses.add(course);
        course.getRegisteredStudents().add(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().add(null);
        }

        return true;
    }

    /**
     * drops the course for a student
     * @param course that will be dropped
     * @return true if the srudent succesfully dropped the course and false otherwise
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }

        int index = course.getRegisteredStudents().indexOf(this);
        registeredCourses.remove(course);
        course.getRegisteredStudents().remove(this);

        for (Assignment assignment : course.getAssignments()) {
            assignment.getScores().remove(index);
        }

        course.getFinalScores().remove(index);

        return true;
    }

    /**
     *  converts a student to a simple string with only the studentId, the studentName and the departmentName
     * @return the simplified string student
     */
    public String toSimplifiedString() {
        return studentId + " " + studentName + " (" + department.getDepartmentName() + ")";
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Student{");
        result.append("studentId='").append(studentId).append('\'');
        result.append(", studentName='").append(studentName).append('\'');
        result.append(", gender=").append(gender);
        result.append(", address=").append(address);
        result.append(", department=").append(department);
        result.append(", registeredCourses=[");

        for (int i = 0; i < registeredCourses.size(); i++) {
            Course course = registeredCourses.get(i);
            result.append(course.getCourseId()).append(" ").append(course.getCourseName())
                    .append(" (").append(course.getDepartment().getDepartmentName()).append(")");
            if (i < registeredCourses.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]}");
        return result.toString();
    }
}
