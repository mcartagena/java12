package com.mcartagena.modernjavainaction.chap02;

import com.mcartagena.modernjavainaction.chap02.FilteringApples.AppleWeightPredicate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class FilteringApplesTest {

    AppleWeightPredicate appleWeightPredicate;

    @Test
    public void testFilter() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        //List<Integer> even = filter(numbers, i -> i % 2 == 0);
        //List<Integer> smallerThanThree = filter(numbers, i -> i < 3);
        //assertEquals(Arrays.asList(2, 4), even);
        //assertEquals(Arrays.asList(1, 2), smallerThanThree);
    }

}