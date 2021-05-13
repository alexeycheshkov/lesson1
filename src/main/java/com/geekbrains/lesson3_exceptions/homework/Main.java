package com.geekbrains.lesson3_exceptions.homework;

public class Main {
    public static void main(String[] args){
        String [][] strinArray = new String[][]{
                {"1","2","3","h"},
                {"5","6","7","8"},
                {"9","10","11","12"},
                {"13","14","15","16"}
        };
        int result=0;
        try {
            result = arraySum(strinArray);
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }
        System.out.println(result);

    }

    public static int arraySum (String[][] stringArray) throws MyArrayDataException, MyArraySizeException{
        int n=4;
        int maxOfRowArray=0;
        int result = 0;
        for (int i=0;i<stringArray.length;i++){
            if (stringArray[i].length>maxOfRowArray){
                maxOfRowArray=stringArray[i].length;
            }
        }
        if (stringArray.length>n || maxOfRowArray>n){
            throw new MyArraySizeException("Неверный размер массива ["+stringArray.length+"]["+maxOfRowArray+"].");
        }
        for (int i=0;i<stringArray.length;i++){
            for (int j=0;j<stringArray[i].length;j++){
                try {
                    result+=Integer.parseInt(stringArray[i][j]);
                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j,stringArray[i][j]);
                }
            }
        }
        return result;
    }
}
