package com.fernando.random_data_api.utils;

import java.util.List;
import java.util.Random;

public final class RandomUtils {
    private RandomUtils() {}

    public static <T> T randomValue(Random random, List<T> data) {
        Integer randomIndex = random.nextInt(data.size() - 0) + 0;
        return data.get(randomIndex);
    }

    public static <T> T randomValue(Random random, T[] data) {
        Integer randomIndex = random.nextInt(data.length - 0) + 0;
        return data[randomIndex];
    }
}