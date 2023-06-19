/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ADMIN
 */
public class Format {
    
    public static String nameStandardization(String name){
        String [] splitArray = name.trim().toLowerCase().split("\\s+");
        
        String finalName = "";
        
        for (int i = 0; i < splitArray.length; i++) {
            int wordSize = splitArray[i].length();
                String perfectName  = splitArray[i].substring(0, 1).toUpperCase();
                perfectName  += splitArray[i].substring(1, wordSize);
                finalName += perfectName + " ";
            
        }
        
        return finalName;
    }
    public static String formatNumber(int number) {
        String numberString = "" + number;
        String reversedNumberString = new StringBuilder(numberString).reverse().toString();
        StringBuilder formattedNumber = new StringBuilder();

        for (int i = 0; i < reversedNumberString.length(); i++) {
            formattedNumber.append(reversedNumberString.charAt(i));

            if ((i + 1) % 3 == 0 && (i + 1) != reversedNumberString.length()) {
                formattedNumber.append(".");
            }
        }
        return formattedNumber.reverse().toString();
    }
    public static void main(String[] args) {
        Format ns = new Format();

    }
}
