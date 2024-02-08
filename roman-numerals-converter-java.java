import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome, enter a number (or more than one) you want to convert, when finished, press any char ");
        
        while (scanner.hasNextInt()) {
         
            int number = scanner.nextInt();
            
            if (number < 10){
                one_digit(number);
            } else if (number > 9 && number < 100){
                two_digits(number);
            } else if (number > 99 && number < 1000){
                three_digits(number);
            }else {
                System.out.println ("Please enter a number in the range 1-999 ");
            }
            System.out.println("");
            System.out.println("Enter the next number");
        }
        System.out.println ("Thank you for using this converter!");
        scanner.close();
  }
  
  
  static void one_digit(int n) {
    if (n!= 0){
        if ( n < 4){
            for ( int i = 0; i < n; i++){
                System.out.print("I");
            }
        }
        else if (n == 4){
            System.out.print("IV");
        }
        else if ( n == 5){
            System.out.print("V");
        }
        else if (n == 9){
            System.out.print("IX");
        }
        else {
            System.out.print("V");
            for ( int j = 0; j< n-5; j++){
                System.out.print("I");
            }
        }
    }
  }
  
  
  static void two_digits(int n){
      int rem = n % 10;
      int tens = n - rem;
      
      if (tens != 0){
          if (tens < 40){
              while (tens != 0){
                  System.out.print("X");
                  tens -= 10;
              }
          }
          else if (tens == 50){
              System.out.print("L");
          }
          else if (tens == 90){
              System.out.print("XC");
          }
          else {
              System.out.print("L");
              tens -= 50;
              while (tens != 0){
                  System.out.print("X");
                  tens-=10;
              }
          }
      }
      if ( rem != 0){
          one_digit(rem);
      }else {
          System.out.print("");
      }
  }
  static void three_digits(int n){
      int ones = n % 10;
      int no_of_tens = ((n - ones) / 10) % 10;
      int tens = no_of_tens * 10;
      int hundreds = n - tens - ones;
      
      if (hundreds == 400){
          System.out.print ( "CD");
      } else if (hundreds == 500){
          System.out.print("D");
      } else if (hundreds == 900){
          System.out.print("CM");
      }else if (hundreds < 400 ){
          while (hundreds != 0){
              System.out.print("C");
              hundreds -= 100;
          }
      } 
      else {
          hundreds -= 500;
          while (hundreds != 0 ){
              System.out.print("C");
              hundreds -= 100;
          }
          System.out.print("D");
      }
      two_digits(tens);
      one_digit(ones);
  }
  
}
