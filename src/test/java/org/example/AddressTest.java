package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testIsPostalCodeValid_Valid() {
        assertTrue(Address.isPostalCodeValid("A1B2C3"));
    }

    @Test
    void testIsPostalCodeValid_Valid2() {
        assertTrue(Address.isPostalCodeValid("K1A0B1"));
    }

    @Test
    void testIsPostalCodeValid_TooShort() {
        assertFalse(Address.isPostalCodeValid("A1B2C"));
    }

    @Test
    void testIsPostalCodeValid_TooLong() {
        assertFalse(Address.isPostalCodeValid("A1B2C3D"));
    }

    @Test
    void testIsPostalCodeValid_WrongFormat1() {
        assertFalse(Address.isPostalCodeValid("1A2B3C"));
    }

    @Test
    void testIsPostalCodeValid_WrongFormat2() {
        assertFalse(Address.isPostalCodeValid("ABCDEF"));
    }

    @Test
    void testIsPostalCodeValid_Null() {
        assertFalse(Address.isPostalCodeValid(null));
    }

    @Test
    void testIsPostalCodeValid_Empty() {
        assertFalse(Address.isPostalCodeValid(""));
    }

    @Test
    void testAddressConstructor_Valid() {
        Address address = new Address(123, "Main Street", "Toronto",
                Address.Province.ON, "M5H2N2");

        assertEquals(123, address.getStreetNo());
        assertEquals("Main Street", address.getStreet());
        assertEquals("Toronto", address.getCity());
        assertEquals(Address.Province.ON, address.getProvince());
        assertEquals("M5H2N2", address.getPostalCode());
    }

    @Test
    void testAddressConstructor_UppercaseConversion() {
        Address address = new Address(123, "Main Street", "Toronto",
                Address.Province.ON, "m5h2n2");

        assertEquals("M5H2N2", address.getPostalCode());
    }

    @Test
    void testAddressConstructor_Invalid() {
        Address address = new Address(123, "Main Street", "Toronto",
                Address.Province.ON, "INVALID");

        assertEquals(0, address.getStreetNo());
        assertNull(address.getStreet());
        assertNull(address.getCity());
        assertNull(address.getProvince());
        assertNull(address.getPostalCode());
    }
}
