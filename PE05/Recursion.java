/**
 * Recursion.java hich implements several static methods.
 * @author Katniss
 * @version 1
 */

public class Recursion {

    /**
     * Creates a method which takes in an array and return a sorted input array.
     * @param arr takes in a String[]
     * @return an ascendingly sorted String[]
     */
    public static String[] mergeSort(String[] arr) {
        if (arr.length == 0 || arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;

        String[] one = mergeSort(RecursionUtils.copyOfRange(arr, 0, mid));
        String[] two = mergeSort(RecursionUtils.copyOfRange(arr, mid, arr.length));
        return RecursionUtils.merge(one, two);
    }

    /**
     * Creates a method which takes in an array returns a ascendingly sorted String[].
     * @param arr takes in a String[]
     * @return ascendingly sorted String[][]
     */
    public static String[] mergeAll(String[][] arr) {
        return rMergeAll(arr, 0);
    }

    private static String[] rMergeAll(String[][] arr, int index) {
        if (index >= arr.length) {
            return new String[0];
        }
        String[] now = arr[index];
        String[] others = rMergeAll(arr, index + 1);
        return RecursionUtils.merge(now, others);
    }

    /**
     * Creates a method which tells us how many duplicate elements exist in the array.
     * @param arr takes in a String[]
     * @return number of duplicate elements in input array
     */
    public static int countDuplicates(String[] arr) {
        if (arr.length == 0 || arr.length <= 1) {
            return 0;
        }

        String[] sub = RecursionUtils.copyOfRange(arr, 1, arr.length);
        int count = countDuplicates(sub);
        if (arr[0].equals(arr[1])) {
            count++;
        }
        return count;
    }

    /**
     * Creates a method which verifies whether a word is a palindrome.
     * @param str takes in a String
     * @return a boolean representing if the input string is a palindrome
     */
    public static boolean verifyPalindrome(String str) {
        if (str == null) {
            return false;
        }

        str = str.toLowerCase();
        if (str.length() <= 1) {
            return true;
        }

        char firstChar = str.charAt(0);
        char lastChar = str.charAt(str.length() - 1);
        if (firstChar == lastChar) {
            return verifyPalindrome(str.substring(1, str.length() - 1));
        } else {
            return false;
        }
    }

    /**
     * Creates a method which verifies whether a word is a palindrome.
     ;
     * @param arr takes in a String[] array containing elements in lexicographica ascending order
     * @param target  String representing the target String to search for
     * @return an int representing the index of target String in input array
     */
    public static int binarySearch(String[] arr, String target) {
        return rBinarySearch(arr, target, 0, arr.length - 1);
    }

    private static int rBinarySearch(String[] arr, String target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (arr[mid].equals(target)) {
            return mid;
        } else if (arr[mid].compareTo(target) < 0) {
            return rBinarySearch(arr, target, mid + 1, end);
        } else {
            return rBinarySearch(arr, target, start, mid - 1);
        }
    }
}
