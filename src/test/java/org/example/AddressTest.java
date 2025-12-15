package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @Test
    void testIsPostalCodeValid_A1B2C3() {
        String input = "A1B2C3";
        boolean expResult = true;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsPostalCodeValid_K1A0B1() {
        String input = "K1A0B1";
        boolean expResult = true;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsPostalCodeValid_tooShort() {
        String input = "A1B2C";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsPostalCodeValid_tooLong() {
        String input = "A1B2C3D";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsPostalCodeValid_wrongFormat1() {
        String input = "1A2B3C";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsPostalCodeValid_wrongFormat2() {
        String input = "ABCDEF";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsPostalCodeValid_null() {
        String input = null;
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testIsPostalCodeValid_emptyString() {
        String input = "";
        boolean expResult = false;
        boolean result = Address.isPostalCodeValid(input);
        assertEquals(expResult, result);
    }

    @Test
    void testAddressConstructor_valid() {
        Address address = new Address(123, "Main Street", "Toronto", Address.Province.ON, "M5H2N2");
        int expStreetNo = 123;
        String expStreet = "Main Street";
        String expCity = "Toronto";
        Address.Province expProvince = Address.Province.ON;
        String expPostalCode = "M5H2N2";

        assertEquals(expStreetNo, address.getStreetNo());
        assertEquals(expStreet, address.getStreet());
        assertEquals(expCity, address.getCity());
        assertEquals(expProvince, address.getProvince());
        assertEquals(expPostalCode, address.getPostalCode());
    }

    @Test
    void testAddressConstructor_uppercase() {
        Address address = new Address(123, "Main Street", "Toronto", Address.Province.ON, "m5h2n2");
        String expPostalCode = "M5H2N2";
        String result = address.getPostalCode();
        assertEquals(expPostalCode, result);
    }

    @Test
    void testAddressConstructor_invalid() {
        Address address = new Address(123, "Main Street", "Toronto", Address.Province.ON, "INVALID");
        int expStreetNo = 0;
        String expStreet = null;
        String expCity = null;
        Address.Province expProvince = null;
        String expPostalCode = null;

        assertEquals(expStreetNo, address.getStreetNo());
        assertEquals(expStreet, address.getStreet());
        assertEquals(expCity, address.getCity());
        assertEquals(expProvince, address.getProvince());
        assertEquals(expPostalCode, address.getPostalCode());
    }
}
