package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        try {
        int base = Integer.parseInt(scan.nextLine());
        String num = scan.nextLine();
        int newBase = Integer.parseInt(scan.nextLine());
        scan.close();
        if(base <= 0 || newBase <= 0 || base > 36 || newBase > 36){
            System.out.println("Error");
            return;
        }
        String[] mas = new String[2];
        double temp;
            if (num.contains(".")) {
                mas = num.split("\\.");
            } else {
                mas[0] = num;
            }
            if (base == 1) {
                temp = num.length();
            } else {
                temp = Long.parseLong(mas[0], base);
                if (num.contains(".")) {
                    for (int i = 0; i < mas[1].length(); i++) {
                        if (Character.isDigit(mas[1].charAt(i))) {
                            temp += (mas[1].charAt(i) - '0') / Math.pow(base, i + 1);
                        } else {
                            temp += (mas[1].charAt(i) - 'a' + 10) / Math.pow(base, i + 1);
                        }
                    }
                }
            }
            if (newBase == 1) {
                for (int i = 0; i < (int) temp; i++) {
                    System.out.print("1");
                }
            } else {
                System.out.print(Long.toString((long) temp, newBase));
                if (num.contains(".")) {
                    System.out.print(".");
                    temp -= Math.floor(temp);
                    for (int i = 0; i < 5 && temp > 0; i++) {
                        temp *= newBase;
                        if (Math.floor(temp) < 10) {
                            System.out.print((char) ((int) temp + '0'));
                        } else {
                            System.out.print((char) ((int) temp - 10 + 'a'));
                        }
                        temp -= Math.floor(temp);
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Error");
        }
    }
}
