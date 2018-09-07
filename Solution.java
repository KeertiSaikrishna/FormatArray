import javax.sound.midi.Soundbank;

public class Solution {
    public void solution(int[] arr, int k) {
        int maxNumber = 0;
        for (int i : arr) {
            if (i > maxNumber)
                maxNumber = i;
        }
        String biggest_element = Integer.toString(maxNumber);
        int maxLengthOfNumber = biggest_element.length();
        int noOfRows = arr.length / k == 0 ? (arr.length / k) : ((arr.length / k) + 1);
        if (noOfRows == 0) {
            noOfRows = 1;
        }
        int noOfLines;
        if (arr.length <= k) {
            noOfLines = 3;
            k = arr.length;
        } else
            noOfLines = (noOfRows * 2) + 1;
        int currentIndex = 0;
        for (int l = 1; l <= (noOfLines); l++) {
            if ((l % 2) == 1) {
                for (int i = 0; i < k; i++) {
                    System.out.print("+");
                    for (int j = 0; j < maxLengthOfNumber; j++) {
                        System.out.print("-");
                    }
                }
                System.out.print("+\n");
            } else {
                for (int i = 0; i < k; i++) {
                    System.out.print("|");
                    String exp = Integer.toString(arr[currentIndex]);
                    int length = exp.length();
                    int gap = maxLengthOfNumber - length;
                    for (int j = 0; j < gap; j++) {
                        System.out.print(" ");
                    }
                    System.out.print(arr[currentIndex++]);
                    if (currentIndex == arr.length) {
                        break;
                    }
                }
                System.out.print("|\n");
                if (currentIndex == arr.length) {
                    if (arr.length % k != 0) {
                        int noEle_lastRow = arr.length % k;
                        for (int i = 0; i < noEle_lastRow; i++) {
                            System.out.print("+");
                            for (int j = 0; j < maxLengthOfNumber; j++) {
                                System.out.print("-");
                            }
                        }
                        System.out.print("+");
                        break;
                    } else {
                        for (int i = 0; i < k; i++) {
                            System.out.print("+");
                            for (int j = 0; j < maxLengthOfNumber; j++) {
                                System.out.print("-");
                            }
                        }
                        System.out.print("+\n");
                        break;
                    }
                }
            }
        }
    }
}