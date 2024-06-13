package org.example;

public class Boolean {
    public static void main(String[] args){
        int[] assessments = {5,4,5,5};
        boolean excellentOrPoor = true;
        boolean ordinary = false;
        for (int i = 0; i < assessments.length; i++){
            if (assessments[i] < 3){
                excellentOrPoor = false;
                break;
            } else if (assessments[i] == 5) {
                excellentOrPoor = true;
            }else{
                ordinary = true;
            }
        }
        if (ordinary){
            System.out.println("обычный ученик");
        } else if(excellentOrPoor){
            System.out.println("отличник");
        }else System.out.println("Двоечник");
        int[] temp = {15,12,14,16,-2};
        boolean checkNegativeTemp = false;
        for (int i = 0; i < temp.length;i++){
            if (temp[i] < 0){
                checkNegativeTemp = true;
            }
        }
        if (checkNegativeTemp){
            System.out.println("В этом месяце были отрицательные температуры");
        }else System.out.println("В этом месяце не было отрицальных температур");
    }
}
