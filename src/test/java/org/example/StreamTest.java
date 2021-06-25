package org.example;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void initializeStream() {
        List<String> stringList = new ArrayList<>();
        stringList.add("String 1");
        stringList.add("String 2");
        Stream<String> stream = stringList.stream();
        Assert.assertEquals(stream.count(), 2);
    }

}
