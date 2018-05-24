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

        // Checks that the user has entered both upper and lower case letters, and not only special characters
        // Case 1 : password is all lowercase
        // Case 2 : password is all uppercase
        // Case 3 : password is all special characters that aren't changed by case
        if(password.toLowerCase()!=password&&password.toUpperCase()!=password)
        {
            rulesPassed++;
        }

        // Tests whether there is a nonletter character
        if(nonLetterCheck(password))
        {
            rulesPassed++;
        }

        // Checks that the password is not letters with a number at the end
        if(!password.matches("^[A-z][A-z]*[0-9][0-9]*$"))
        {
            rulesPassed++;
        }

        return rulesPassed;

    }

    private static boolean nonLetterCheck(String password)
    {

        // Checks that the password contains at least one character that isn't a letter
        // Compare the uppercase string to the lowercase string. If any of the indexis are the same,
        // it's a special character (i.e. number, punctuation, etc.)
        boolean specialChar= false;
        for(int i = 0; i< password.length();i++)
        {
            if(password.toLowerCase().charAt(i)==password.toUpperCase().charAt(i))
            {
                specialChar=true;
                i = password.length();
            }
        }
        return specialChar;
    }
}