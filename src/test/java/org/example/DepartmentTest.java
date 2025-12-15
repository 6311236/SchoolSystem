package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testIsDepartmentNameValid_ComputerScience() {
        String input = "ComputerScience";
        boolean expResult = true;
        boolean result = Department.isDepartmentNameValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsDepartmentNameValid_ComputerScienceWithSpace() {
        String input = "Computer Science";
        boolean expResult = true;
        boolean result = Department.isDepartmentNameValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsDepartmentNameValid_MultipleWords() {
        String input = "Computer Science And Math";
        boolean expResult = true;
        boolean result = Department.isDepartmentNameValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsDepartmentNameValid_containsNumbers() {
        String input = "Computer Science 101";
        boolean expResult = false;
        boolean result = Department.isDepartmentNameValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsDepartmentNameValid_containsSpecialChars() {
        String input = "Computer-Science";
        boolean expResult = false;
        boolean result = Department.isDepartmentNameValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsDepartmentNameValid_null() {
        String input = null;
        boolean expResult = false;
        boolean result = Department.isDepartmentNameValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsDepartmentNameValid_emptyString() {
        String input = "";
        boolean expResult = false;
        boolean result = Department.isDepartmentNameValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testDepartmentConstructor_valid() {
        Department dept = new Department("Computer Science");
        String expDepartmentName = "Computer Science";
        String result = dept.getDepartmentName();
        assertEquals(expDepartmentName, result);
        assertNotNull(dept.getDepartmentId());
    }

    @Test
    void testDepartmentConstructor_titleCase() {
        Department dept = new Department("computer science");
        String expDepartmentName = "Computer Science";
        String result = dept.getDepartmentName();
        assertEquals(expDepartmentName, result);
    }

    @Test
    void testDepartmentConstructor_invalid() {
        Department dept = new Department("Computer-Science");
        String expDepartmentId = null;
        String expDepartmentName = null;
        String resultId = dept.getDepartmentId();
        String resultName = dept.getDepartmentName();
        assertEquals(expDepartmentId, resultId);
        assertEquals(expDepartmentName, resultName);
    }

    @Test
    void testSetDepartmentName_valid() {
        Department dept = new Department("Computer Science");
        dept.setDepartmentName("Mathematics");
        String expDepartmentName = "Mathematics";
        String result = dept.getDepartmentName();
        assertEquals(expDepartmentName, result);
    }

    @Test
    void testSetDepartmentName_titleCase() {
        Department dept = new Department("Computer Science");
        dept.setDepartmentName("mathematics");
        String expDepartmentName = "Mathematics";
        String result = dept.getDepartmentName();
        assertEquals(expDepartmentName, result);
    }

    @Test
    void testSetDepartmentName_invalid() {
        Department dept = new Department("Computer Science");
        dept.setDepartmentName("Math-101");
        String expDepartmentName = null;
        String result = dept.getDepartmentName();
        assertEquals(expDepartmentName, result);
    }
}
