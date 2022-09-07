package com.temp;

import org.junit.Test;

import java.time.ZonedDateTime;

public class TempTest {

    @Test
    public void test1() {
        ZonedDateTime time = ZonedDateTime.now();
        System.out.println(time);
    }
}
