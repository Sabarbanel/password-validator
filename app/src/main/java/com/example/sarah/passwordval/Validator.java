package com.example.sarah.passwordval;

public class Validator {

    public static int validate(String password)
    {
        int rulesPassed=0;

        //check that it isn't password
        if(!password.toLowerCase().equals("password"))
        {
            rulesPassed++;
        }

        //check that it's at least 8 chars
        if(password.length()>7)
        {
            rulesPassed++;
        }
        return  rulesPassed;
 }
}