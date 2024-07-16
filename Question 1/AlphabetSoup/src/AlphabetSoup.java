import java.util.Arrays;
import java.util.Scanner;

/*************************************************
 Created By : Yolanda Parawita
 Created Date : 16/7/2024 12:02 pm
 ************************************************/

public class AlphabetSoup {
    public static String alphabetSoup(String str){
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    public static void main(String[] args){
        System.out.println("Example : ");
        System.out.println("coderbyte -> " +alphabetSoup("coderbyte"));
        System.out.println("hooplah -> " +alphabetSoup("hooplah"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nTry another sample, Enter a string : ");
        String input = scanner.nextLine();

        String result = alphabetSoup(input);
        System.out.println("Result: " + result);
    }
}
