package com.studentapp.testbase;

import java.util.Random;

/**
 * Created by magn on 11/7/2017.
 */
public class TestUtils {

    public static String getRandomValue() {
        Random random = new Random();
        Integer intRandom = random.nextInt(100000);
        return intRandom.toString();
    }
}
