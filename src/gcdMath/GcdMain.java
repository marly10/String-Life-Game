package gcdMath;

import javafx.scene.layout.VBox;

import java.math.*;
import java.util.*;

public class GcdMain extends VBox {
    public static void main(String[] args) {

//------>To-do:
        //1. ask user for 2 int inputs [p,q]---[DONE]
        //2. check/confirm the number's [p,q] entered by the user are prime
        //--->if both numbers entered are not prime, then we ask for the numbers again---[DONE]

        //3. if both number are prime: calculate N = (p)(q) & n = (p-1)(q-1)---[DONE]
        //--->user pick e: [0 < e < N]---[NOT-DONE]

        //4. define the gcd(e, N) = 1
        //--->if  gcd(e, N) != 1, then continue asking for e: [0 < e < N]

        //5. define the coefficients[r, s]: (r)(e) + (s)(N) negative value over here = 1
        //--->r = d

        //6. e for encryption
        //7. d for decryption

        //ascii ^ e to encrypt
        //ascii ^ d to decrypt

        ArrayList<Integer> inverseArray = new ArrayList<Integer>();

        Scanner k = new Scanner(System.in);
        GcdFile file = new GcdFile();

        int p, q;
        NumInverse t = new NumInverse();

        char[] letterAdded;

        //check if value are prime
        System.out.println("Let's Begin Encrypting:\n");
        do {
            System.out.println("Enter 2 Prime numbers [PORFAVOR]: ");
            p = k.nextInt();
            q = k.nextInt();

            if (p > 2000 || p < 1000 || q < 100 || q > 2000) {
                System.out.println("[P] should be: 1000<p<2000 & 100<q<2000");
            }
            //report the error in primes found
            else if (!t.isPrime(p) && !t.isPrime(q)) {
                System.out.println("\nNumber: [" + p + "] is not a prime");
                System.out.println("Number: [" + q + "] is not a prime");
            }

            //report the error in primes found
            else if (t.isPrime(p) && !t.isPrime(q)) {
                System.out.println("\nNumber: [" + p + "] is a prime");
                System.out.println("Number: [" + q + "] is not a prime");
            }

            //report the error in primes found
            else if (!t.isPrime(p) && t.isPrime(q)) {
                System.out.println("\nNumber: [" + p + "] is not a prime");
                System.out.println("Number: [" + q + "] is a prime");
            }

        } while (!t.isPrime(p) && !t.isPrime(q) || t.isPrime(p) && !t.isPrime(q) || !t.isPrime(p) && t.isPrime(q) || p > 2000 || p < 1000 || q < 100 || q > 2000
        );

        //define n & N & e
        int smallNValue = 0, bigNValue = 0, e = 0;

        //number of inverse in value[N] & Z[n]
        smallNValue = p * q;
        bigNValue = (p - 1) * (q - 1);

        System.out.println("\n[Values for N & n found:]: ");
        System.out.println("[n]: " + smallNValue);
        System.out.println("[N]: " + bigNValue);

        //stores the number of inverses [n] contains
        for (int i = 1; i < smallNValue; i++) {
            //if the gcd is 1 then it'/.s an inverse
            if (file.gcdFunction(i, smallNValue) == 1) {
                inverseArray.add(i);
            }
        }

        /*System.out.print("\n[INVERSES FOUND]: ");
        for (Integer integer : inverseArray) {
            System.out.print(integer+" ");
        }*/

        do {
            //asking for e
            System.out.print("\n[USER] pick [e]: ");
            e = k.nextInt();

            if (file.gcdFunction(e, bigNValue) != 1)
                System.out.print("\nValue[e]: " + e + " & " + "Value[N]: " + bigNValue + " Don't have a GCD of 1");
            else if (e > bigNValue || e < 0)//keeping e smaller than N
                System.out.printf("Value entered for e[%d] is larger than N[%d]\n", e, bigNValue);

            //checking if e & n have a gcd of 1 & e isn't greater than N
        } while (file.gcdFunction(e, bigNValue) != 1 || e > bigNValue);

        /*
        AtomicInteger x = new AtomicInteger(), y = new AtomicInteger();
        System.out.println("The GCD is " + file.extended_gcd(p, q, x, y));
        System.out.printf("s = %d, r = %d\n", x.get(), y.get());
        int finalValue = (p) * (x.get()) + (y.get()) * (q);
        System.out.printf("Final = %d\n", finalValue);
        */

        int d = 0;
        //CHECK that e*i%N = 1
        for (int i = 0; i < bigNValue; i++) {
            //finding d in N
            if ((e * i) % bigNValue == 1) {
                // d is found here
                System.out.printf("[Test:] = %d\n", (e * i) % bigNValue);
                d = i;
            }
        }

        System.out.println();
        System.out.printf("[d] = %d\n", d);
        System.out.println();

        //string being written by the user:
        String unwantedText = k.nextLine();
        System.out.print("String we will Encrypt: ");
        String dataEncrypted = k.nextLine();

        //--
        // Creating array of string length
        letterAdded = new char[dataEncrypted.length()];

        // Copy character by character into array
        for (int i = 0; i < dataEncrypted.length(); i++) {
            letterAdded[i] = dataEncrypted.charAt(i);
        }

        //
        String[] asciiArr = new String[letterAdded.length];

        // Printing content of array
        System.out.print("\n--------------------------------\n");
        System.out.print("MESSAGE: ");
        System.out.print(" [ ");
        for (char c : letterAdded) {
            System.out.print(c);
        }
        System.out.print(" ]");
        System.out.print("\n--------------------------------");
        //SPACING
        System.out.println();
        System.out.println();

        System.out.print("--------------------------------\n");
        System.out.print("[ASCII MESSAGE VALUE]: ");
        for (int i = 0; i < asciiArr.length; i++) {
            //convert to octal String NEW: convert to ASCII
            int asciiNumber = letterAdded[i];

            //converting the ASCII value to string [ADDING 0]
            String asciiNumberTemp = Integer.toString(asciiNumber);

            //LESS THAN 100 PLACE 0
            if (asciiNumber < 100) {
                asciiNumberTemp = "0" + asciiNumberTemp;
            }

            //LESS THAN 10 PLACE 0
            if (asciiNumber < 10) {
                asciiNumberTemp = "0" + asciiNumberTemp;
            }

            //placing number in our array of string
            asciiArr[i] = asciiNumberTemp;
            System.out.print(asciiArr[i] + " ");
        }
        System.out.print("\n--------------------------------\n");

        //string added into groups based on location
        ArrayList<String> combinationArray = new ArrayList<String>();
        for (int i = 0; i < asciiArr.length; i++) {
            if (i + 2 < asciiArr.length + 1) {
                combinationArray.add(asciiArr[i] + asciiArr[i + 1]);
                i++;
            } else {
                combinationArray.add(asciiArr[i]);
            }
        }
        System.out.print("\n--------------------------------\n");
        System.out.print("[m]: ");
        for (String i : combinationArray) {
            System.out.print(i + " ");
        }
        System.out.print("\n--------------------------------\n\n");

        BigInteger nBI = new BigInteger("" + smallNValue);

        //ENCRYPTION PROCESS:
        System.out.print("[ENCRYPTING START]");
        System.out.print("\n--------------------------------\n");
        ArrayList<BigInteger> M = new ArrayList<>();

        for (String s : combinationArray) {
            BigInteger largeNum = new BigInteger(s);
            M.add(largeNum.pow(e).mod(nBI));
        }

        System.out.print("[M]: ");

        for (BigInteger bigInteger : M) {
            System.out.print(bigInteger + " ");
        }
        System.out.print("\n--------------------------------\n");
        System.out.println("[ENCRYPTING END]");
        System.out.println();


        System.out.print("[DECRYPTION START]"); //for spacing...
        System.out.print("\n--------------------------------\n");
        System.out.print("[m]: ");
        ArrayList<BigInteger> decryptedM = new ArrayList<BigInteger>();

        //fitting back into decryptedM
        BigInteger bigTemp = new BigInteger("100000");
        for (int i = 0; i < M.size(); i++) {

            decryptedM.add(M.get(i).pow(d).mod(nBI));
//if less than six digits add 0 before
            if (decryptedM.get(i).compareTo(bigTemp) < 0) {
                System.out.print("0" + decryptedM.get(i) + " ");
            } else {
                System.out.print(decryptedM.get(i) + " ");
            }
        }
        System.out.print("\n--------------------------------\n");
        System.out.println("[DECRYPTING END]");

    }
}
