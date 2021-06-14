package org.example;

import com.mahiznan.challenges.core.Generics;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

public class GenericsTest {

    @Test
    public void checkArrayToList() {
        Integer[] array = {1, 2, 3, 4, 5};
        List<String> stringList = Generics.fromArrayToList(array, Objects::toString);
        assertThat(stringList, hasItems("1", "2", "3", "4", "5"));
    }
}
