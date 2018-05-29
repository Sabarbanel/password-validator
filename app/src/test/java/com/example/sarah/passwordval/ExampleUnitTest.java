package com.example.sarah.passwordval;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void correctCase() {
        assertEquals(4,Validator.validate("rooo1234oooof"));
        assertEquals(4, Validator.validate("ROOO1234OOOOF"));
    }
    @Test
    public void isPassword(){
        assertEquals(3,Validator.validate("paSsword"));
    }
    @Test
    public void regex(){
        assertEquals(4,Validator.validate("paSsword1234"));
    }
    @Test
    public void noLettersOrOnlyLetters() {
        assertEquals(4, Validator.validate("12345678"));
        assertEquals(4, Validator.validate("FloooooooofyCat"));
    }

    @Test
    public void perfectPasswords(){
        assertEquals(5,Validator.validate("13%CAtsP"));
        assertEquals(5,Validator.validate("R5(9grite34"));
    }

}