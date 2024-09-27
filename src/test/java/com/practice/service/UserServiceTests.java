package com.practice.service;

import com.practice.repository.UserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;
    @Disabled
    @ParameterizedTest
    @CsvSource({
            "Karl",
            "Thomas",
            "Canady"
    })
    public void testFindByUserName(String name) {
        assertNotNull(userRepository.findByUserName(name));
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "1,1,2",
            "2,10,12",
            "3,3,9"
    })
    public void test(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }

//    @BeforeAll
//    public void setUp() {
//
//    }
//    @BeforeEach :- run for each test run
//    @BeforeAll :- Test for all test cas
//    @AfterEach :- test after every single test
//    @AfterAll:- test every 1000 test if they exiest
}
