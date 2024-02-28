package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Convertions {
    static String changeLetterToNum(String[] num , String equation, String[] letters){
        for(int i = 0; i<= letters.length - 1; i++){
            equation= equation.replace(letters[i],num[i]);
        }
        return equation;
    }

    static String[] createVariableArray(String equation){
        List<String> variableList = new ArrayList<>();
        int nOfVariables = 0;
        for (int i = 0; i < equation.length(); i++) {
            if(Character.isLetter(equation.charAt(i))){
                if(variableList.isEmpty()) {
                    variableList.add(String.valueOf(equation.charAt(i)));
                }else {
                    if(!variableList.contains(String.valueOf(equation.charAt(i)))){
                        variableList.add(String.valueOf(equation.charAt(i)));
                    }
                }
            }
        }
        return turnListIntoArray(variableList);
    }

    static String[] turnListIntoArray(List<String> list){
        String[] array = new String[list.size()];
        for (int i = 0; i < list.size() ; i++) {
            array[i]= list.get(i);
        }
        return array;
    }

    static String[] assignValuesToLetterVariable(String[] variables){
        Scanner scanner = new Scanner(System.in);
        String[] variableValuesArray = new String[variables.length];
        for (int i = 0; i < variables.length ; i++) {
            System.out.println("Qual o valor da variavel "+variables[i]+" ?:");
            String variableValue = scanner.nextLine();
            variableValuesArray[i]=variableValue;
        }
        return variableValuesArray;
    }
}
