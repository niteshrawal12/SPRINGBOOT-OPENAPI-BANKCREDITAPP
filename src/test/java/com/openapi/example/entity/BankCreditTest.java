package com.openapi.example.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BankCreditTest {

    private BankCredit bankCreditUnderTest;

    @BeforeEach
    void setUp() {
        bankCreditUnderTest = new BankCredit();
    }

    @Test
    void testEquals() {
        assertThat(bankCreditUnderTest.equals("o")).isFalse();
    }

    @Test
    void testCanEqual() {
        assertThat(bankCreditUnderTest.canEqual("other")).isFalse();
    }

    @Test
    void testHashCode() {
        assertThat(bankCreditUnderTest.hashCode()).isNotEqualTo(0);
    }

    @Test
    void testToString() {
        assertThat(bankCreditUnderTest.toString()).isNotNull();
    }
}
