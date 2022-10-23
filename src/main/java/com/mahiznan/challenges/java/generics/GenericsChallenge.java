package com.mahiznan.challenges.java.generics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenericsChallenge {

    public <T> List<T> arrayToList(T[] v) {
        return Arrays.stream(v).collect(Collectors.toList());
    }

}
