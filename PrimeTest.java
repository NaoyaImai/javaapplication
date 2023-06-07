package org.example.main.java.org.example;

import org.example.PrimeNumber;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generatePrimes() {
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(2, 3, 5));
        assertEquals(expected1, PrimeNumber.generate(3));
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13));
        assertEquals(expected2, PrimeNumber.generate(6));
    }

    @Test
    void isPrime() {
        assertEquals(true, PrimeNumber.isPrime(3));
        assertEquals(true, PrimeNumber.isPrime(5));
        assertEquals(true, PrimeNumber.isPrime(7));
        assertEquals(true, PrimeNumber.isPrime(11));
        assertEquals(true, PrimeNumber.isPrime(13));
        assertEquals(true, PrimeNumber.isPrime(79));
        assertEquals(false, PrimeNumber.isPrime(4));
        assertEquals(false, PrimeNumber.isPrime(6));
        assertEquals(false, PrimeNumber.isPrime(9));
        assertEquals(false, PrimeNumber.isPrime(12));
        assertEquals(false, PrimeNumber.isPrime(91));

    }
}