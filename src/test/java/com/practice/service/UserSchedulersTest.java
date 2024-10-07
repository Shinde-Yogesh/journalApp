package com.practice.service;

import com.practice.schedular.UserSchedular;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulersTest {

    @Autowired
    private UserSchedular userSchedular;

    @Test
    public void testFetchUsersAndSendSaMail()
    {
        userSchedular.fetchUsersAndSendSaMail();
    }
}
