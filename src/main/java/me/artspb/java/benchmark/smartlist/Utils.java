package me.artspb.java.benchmark.smartlist;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

class Utils {

    static List<String> fill(final List<String> list, final int size) {
        for (int i = 0; i < size; i++) {
            list.add(randomString());
        }
        return list;
    }

    static List<String> fillFactory(final int size) {
        if (size == 0) {
            return Collections.emptyList();
        } else if (size == 1) {
            return Collections.singletonList(randomString());
        } else {
            return Arrays.asList(randomStrings(size));
        }
    }

    @NotNull
    static String[] randomStrings(int size) {
        final String[] strings = new String[size];
        for (int i = 0; i < size; i++) {
            strings[i] = randomString();
        }
        return strings;
    }

    static String randomString() {
        return UUID.randomUUID().toString();
    }
}
