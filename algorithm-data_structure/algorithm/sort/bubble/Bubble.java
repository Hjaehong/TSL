package data_structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BubbleSort {

    public static void main(String[] args) {

        // 초기 값
        int[] init = {3, 7, 1, 1, 8, 4, 3, 6, 7};
        System.out.println("정렬 전 = " + Arrays.toString(init));
        // 버블 정렬
        Bubble(init);
        // sout으로 init을 찍었을 때 값이 안나오고 이상한 값이 나온 이유는 자바에서 배열선언된 변수는 해당 배열의 주소를 가르켜서?
        // -> 자바에서 배열은 객체이기 떄문에 배열의 내용을 출력하고 싶다면 for을 쓰거나 Arrays.toString을 이용한다.
        System.out.println("정렬 후 = " + Arrays.toString(init));

        int[] noDulication = Deduplication(init);
        System.out.println("중복 해제 후 = " + Arrays.toString(noDulication));

    }

    public static void Bubble(int[] input) {

        // 배열의 길이
        int length = input.length;

        for(int i = 0; i < length; i++) {
            //for(int j = i + 1; j < length; j++) {
            for(int j = 0; j < length - i - 1; j++) {
                if(input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
    }

    // 중복 제거
    public static int[] Deduplication(int[] input) {
        // 중복이 제거된 배열을 저장 할 result 배열
        List<Integer> result = new ArrayList<>();

        // input값을 정수형 변수 num에 하나씩 넣으면서 중복되지 않으면 추가 한다.
        for(int num : input) {
            if(!result.contains(num)) {
                result.add(num);
            }
        }

        // 중복 제거 된 값을 넣을 배열 크기를 result 리스트의 사이즈 만큼 지정한다.
        // 배열에서 길이는 length, 리스트에서 길이는 size()
        int[] arr = new int[result.size()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }
}
