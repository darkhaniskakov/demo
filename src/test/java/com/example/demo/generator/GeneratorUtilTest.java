package com.example.demo.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeneratorUtilTest {

    @Test
    public void nextCode_WhenCurrentA0A0_ShouldReturnA0A1() {
        assertEquals("a0a1", GeneratorUtil.nextCode("a0a0"));
    }

    @Test
    public void nextCode_WhenCurrentA0A9_ShouldReturnA0B0() {
        assertEquals("a0b0", GeneratorUtil.nextCode("a0a9"));
    }

    @Test
    public void nextCode_WhenCurrentA0Z9_ShouldReturnA1A0() {
        assertEquals("a1a0", GeneratorUtil.nextCode("a0z9"));
    }

    @Test
    public void nextCode_WhenCurrentZ9Z9_ShouldReturnA0A0A0() {
        assertEquals("a0a0a0", GeneratorUtil.nextCode("z9z9"));
    }

}