package Backtracking;

/**
 *
 * @author Balram
 */
public class StringPermutation {

    public static void main(String args[]) {
        String input = "abc";
        findPermutation("", input);
    }

    public static void findPermutation(String beginningString, String endingString) {
        if (endingString.length() <= 1) {
            System.out.println(beginningString + endingString);
        } else {
            for (int i = 0; i < endingString.length(); i++) {
                String newString = endingString.substring(0, i) + endingString.substring(i + 1);
                    //line 1 debugger    System.out.println("i="+i+", newString=" + newString + ", endingString.substring(0, i)=" + endingString.substring(0, i) + ", endingString.substring(i + 1)=" + endingString.substring(i + 1));
                //line 2 debugger    System.out.println("beginningString=" + beginningString + ", endingString.charAt(i)=" + endingString.charAt(i) + ", arg1=" + beginningString + endingString.charAt(i) + "arg2=" + newString);
                findPermutation(beginningString + endingString.charAt(i), newString);
            }
        }
    }
}
