package JAVA;
import java.math.BigInteger;

class Multiply { 

    //metoda s vyuzitim BigInt
    static String multiplyBigInt(String input1, String input2) {
        if (input1.length() == 0 || input2.length() == 0) {
            return "0";
        }

        BigInteger num_1 = new BigInteger(input1);
        BigInteger num_2 = new BigInteger(input2);

        BigInteger multiplied = num_1.multiply(num_2);
        return multiplied.toString();
    }
        
    // methoda bez vyuzitia BigInt 
    static String multiplyNoBigInt(String input1, String input2) { 
        String sign = "";
        if ((input1.charAt(0) == '-' || input2.charAt(0) == '-') && (input1.charAt(0) != '-' || input2.charAt(0) != '-')) { 
            sign = "-";
        }

        if (input1.charAt(0) == '-' && input2.charAt(0) != '-') { 
            input1 = input1.substring(1); 
        }  
        else if (input1.charAt(0) != '-' && input2.charAt(0) == '-') { 
            input2 = input2.substring(1); 
        }  
        else if (input1.charAt(0) == '-' && input2.charAt(0) == '-') { 
            input1 = input1.substring(1); 
            input2 = input2.substring(1); 
        } 

        if (input1.length() == 0 || input2.length() == 0) { 
            return "0"; 
        }

        int result[] = new int[input1.length() + input2.length()];
        int pom1 = 0;  
        int pom2 = 0;  
        for (int i = input1.length() - 1; i >= 0; i--) { 
            int pom = 0; 
            int n1 = input1.charAt(i) - '0'; 
    
            pom2 = 0; 

            for (int j = input2.length() - 1; j >= 0; j--){ 
                int n2 = input2.charAt(j) - '0'; 
                int sum = n1 * n2 + result[pom1 + pom2] + pom; 
                pom = sum / 10; 
                result[pom1 + pom2] = sum % 10;     
                pom2++; 
            } 

            if (pom > 0) {
                result[pom1 + pom2] += pom; 
            } 
            pom1++; 
        } 

        int i = result.length - 1; 
        while (i >= 0 && result[i] == 0) {
            i--; 
        } 

        if (i == -1) { 
            return "0"; 
        }

        String resultFinal = "";
        resultFinal += sign; 
        
        while (i >= 0) { 
            resultFinal += (result[i--]); 
        }

        return resultFinal; 
    } 

    //main loop
    public static void main(String[] args) { 
        String inputNumber1 = args[1];
        String inputNumber2 = args[2];
        
        String inputType = args[0];

        if (inputType.equals("BigInt")) {
            System.out.println(multiplyBigInt(inputNumber1, inputNumber2));
        }else if (inputType.equals("NoBigInt")) {             
            System.out.println(multiplyNoBigInt(inputNumber1, inputNumber2)); 
        }else if(inputType.equals("Both")) {
            String pomNum1 = multiplyBigInt(inputNumber1, inputNumber2);
            String pomNum2 = multiplyNoBigInt(inputNumber1, inputNumber2);
            System.out.println(pomNum2);
            System.out.println(pomNum1);
            System.out.println(pomNum2.equals(pomNum1));
        }
    } 
}       