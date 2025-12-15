package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentTest {

    @Test
    void testIsDepartmentNameValid_ValidLettersOnly() {
        assertTrue(Department.isDepartmentNameValid("ComputerScience"));
    }

    @Test
    void testIsDepartmentNameValid_ValidWithSpaces() {
        assertTrue(Department.isDepartmentNameValid("Computer Science"));
    }

    @Test
    void testIsDepartmentNameValid_ValidMultipleWords() {
        assertTrue(Department.isDepartmentNameValid("Computer Science And Math"));
    }

    @Test
    void testIsDepartmentNameValid_InvalidNumbers() {
        assertFalse(Department.isDepartmentNameValid("Computer Science 101"));
    }

    @Test
    void testIsDepartmentNameValid_InvalidSpecialChars() {
        assertFalse(Department.isDepartmentNameValid("Computer-Science"));
    }

    @Test
    void testIsDepartmentNameValid_Null() {
        assertFalse(Department.isDepartmentNameValid(null));
    }

    @Test
    void testIsDepartmentNameValid_Empty() {
        assertFalse(Department.isDepartmentNameValid(""));
    }

    @Test
    void testDepartmentConstructor_Valid() {
        Department dept = new Department("Computer Science");

        assertNotNull(dept.getDepartmentId());
        assertTrue(dept.getDepartmentId().startsWith("D"));
        assertEquals("Computer Science", dept.getDepartmentName());
    }

    @Test
    void testDepartmentConstructor_TitleCase() {
        Department dept = new Department("computer science");

        assertEquals("Computer Science", dept.getDepartmentName());
    }

    @Test
    void testDepartmentConstructor_Invalid() {
        Department dept = new Department("Computer-Science");

        assertNull(dept.getDepartmentId());
        assertNull(dept.getDepartmentName());
    }

    @Test
    void testDepartmentConstructor_AutoIncrement() {
        Department dept1 = new Department("Computer Science");
        Department dept2 = new Department("Mathematics");

        assertNotEquals(dept1.getDepartmentId(), dept2.getDepartmentId());
    }

    @Test
    void testSetDepartmentName_Valid() {
        Department dept = new Department("Computer Science");
        dept.setDepartmentName("Mathematics");

        assertEquals("Mathematics", dept.getDepartmentName());
    }

    @Test
    void testSetDepartmentName_TitleCase() {
        Department dept = new Department("Computer Science");
        dept.setDepartmentName("mathematics");

        assertEquals("Mathematics", dept.getDepartmentName());
    }

    @Test
    void testSetDepartmentName_Invalid() {
        Department dept = new Department("Computer Science");
        dept.setDepartmentName("Math-101");

        assertNull(dept.getDepartmentName());
    }
}
