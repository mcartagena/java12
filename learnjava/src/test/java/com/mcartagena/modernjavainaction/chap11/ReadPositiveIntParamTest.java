package com.mcartagena.modernjavainaction.chap11;

import org.junit.Before;
import org.junit.Test;

import java.util.Properties;

import static org.junit.Assert.assertEquals;

public class ReadPositiveIntParamTest {
    ReadPositiveIntParam readPositiveIntParam;
    Properties props;

    @Before
    public void setupBefore(){
        readPositiveIntParam = new ReadPositiveIntParam();
        props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");
    }

    @Test
    public void testMapImperatively() {

        assertEquals(5, readPositiveIntParam.readDurationImperative(props, "a"));
        assertEquals(0, readPositiveIntParam.readDurationImperative(props, "b"));
        assertEquals(0, readPositiveIntParam.readDurationImperative(props, "c"));
        assertEquals(0, readPositiveIntParam.readDurationImperative(props, "d"));

    }

    @Test
    public void testMapWithOptional(){
        assertEquals(5, readPositiveIntParam.readDurationWithOptional(props, "a"));
        assertEquals(0, readPositiveIntParam.readDurationWithOptional(props, "b"));
        assertEquals(0, readPositiveIntParam.readDurationWithOptional(props, "c"));
        assertEquals(0, readPositiveIntParam.readDurationWithOptional(props, "d"));
    }

}