import javax.sound.midi.Soundbank;

public class Solution {
    public void solution(int[] arr, int k) {
        int max = 0;
        for (int i : arr) {
            if (i > max)
                max = i;
        }
        String biggest_element = Integer.toString(max);
        int max_length = biggest_element.length();
        int no_rows = arr.length / k == 0 ? (arr.length / k) : ((arr.length / k) + 1);
        if(no_rows == 0){
            no_rows = 1;
        }
        int no_lines;
        if (arr.length <= k) {
            //System.out.println("arr length: " + arr.length + " k:" + k);
            no_lines = 3;
            k = arr.length;
        } else
            no_lines = (no_rows * 2) + 1;
        int curr_index = 0;
        for (int l = 1; l <= (no_lines); l++) {
            if ((l % 2) == 1) {
                for (int i = 0; i < k; i++) {
                    System.out.print("+");
                    for (int j = 0; j < max_length; j++) {
                        System.out.print("-");
                    }
                }
                System.out.print("+\n");
            } else {
                for (int i = 0; i < k; i++) {
                    System.out.print("|");
                    String exp = Integer.toString(arr[curr_index]);
                    int length = exp.length();
                    int gap = max_length - length;
                    for (int j = 0; j < gap; j++) {
                        System.out.print(" ");
                    }
                    System.out.print(arr[curr_index++]);
                    if(curr_index == arr.length){
                        //System.out.print("|\n");
                        //System.out.print("+");
                        break;
                    }
                }
                System.out.print("|\n");
                if(curr_index == arr.length){
                    if( arr.length % k != 0) {
                        int noEle_lastRow = arr.length % k;
                        for (int i = 0; i < noEle_lastRow; i++) {
                            System.out.print("+");
                            for (int j = 0; j < max_length; j++) {
                                System.out.print("-");
                            }
                        }
                        System.out.print("+");
                        break;
                    }
                    else {
                        for (int i = 0; i < k; i++) {
                            System.out.print("+");
                            for (int j = 0; j < max_length; j++) {
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