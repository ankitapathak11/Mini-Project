package com.password;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator 
{
	// The line `private static final String DIGITS = "0123456789";` is declaring a constant variable
    // named `DIGITS` of type `String`. It is assigned the value `"0123456789"`, which represents all
    // the digits from 0 to 9. This constant is used in the `PasswordGenerator` class to include digits
    // in the generated password if the user specifies it in the character set.
	
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    private String charset;
    private int length;
    private List<String> charArray;
    private List<Character> password;

    public PasswordGenerator(String charset, int length) 
    {
        this.charset = charset;
        this.length = length;
        this.charArray = new ArrayList<>();
        this.password = new ArrayList<>();
    }

    public void setTheCharset() 
    {
        if (charset.contains("l")) 
        {
            charArray.add(LOWERCASE);
        }

        if (charset.contains("u")) 
        {
            charArray.add(UPPERCASE);
        }

        if (charset.contains("d")) 
        {
            charArray.add(DIGITS);
        }

        if (charset.contains("s")) 
        {
            charArray.add(SPECIAL_CHARACTERS);
        }
    }

    public List<String> getCharArray() 
    {
        return charArray;
    }

    public void generatePassword() 
    {
        Random random = new Random();

        for (int i = 0; i < length; i++) 
        {
            int outerIndex = random.nextInt(charArray.size());
            String innerString = charArray.get(outerIndex);
            int innerIndex = random.nextInt(innerString.length());
            password.add(innerString.charAt(innerIndex));
        }
    }

    public String getPassword() 
    {
        StringBuilder sb = new StringBuilder();
        for (Character c : password) 
        {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the character set you want to use (l for lowercase, u for uppercase, d for digits, s for special characters):");
        String charset = scanner.nextLine();
        System.out.println("Enter the length of the password:");
        int length = scanner.nextInt();

        PasswordGenerator passwordGenerator = new PasswordGenerator(charset, length);
        passwordGenerator.setTheCharset();
        passwordGenerator.generatePassword();
        String generatedPassword = passwordGenerator.getPassword();
        System.out.println("Generated Password: " + generatedPassword);
    }
}
