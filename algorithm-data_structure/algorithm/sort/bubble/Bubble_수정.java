import java.util.*;

public class Bubble {

    public static void main(String[] args) {

        // 초기 값
        int[] init = {3, 7, 1, 1, 8, 4, 3, 6, 7};
        Set<Integer> result = Deduplication(init);
        Bubble(result);
        
        System.out.println("정렬 후 = " + result);
    }

    public static void Bubble(Set<Integer> input) {

        //  배열의 길이
        int length = input.size();
        List<Integer> num = new ArrayList<>(input);
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length - i - 1; j++) {
                if(num.get(j) > num.get(j + 1)) {
                    int temp = num.get(j);
                    num.set(j, num.get(j + 1));
                    num.set(j + 1, temp);
                }
            }
        }
    }

    // 중복 제거
    public static Set<Integer> Deduplication(int[] input) {
        // 중복이 제거된 배열을 저장 할 result List
//        List<Integer> result = new ArrayList<>();
        // --> list로 저장했는데 그냥 배열로 저장하면 안돼나?
        // --> 둘 다 시간 복잡도가 O(n^2)여서 크게 의미가 없음
        // --> HashSet을 이용, hashset에 들어간 데이터들은 자동으로 중복이 제거가 된다.
        Set<Integer> result = new HashSet<>();

        for(int i = 0; i < input.length; i++) {
            result.add(input[i]);
        }
        // 중복 제거 된 값을 넣을 배열 크기를 result 리스트의 사이즈 만큼 지정한다.
        // 배열에서 길이는 length, 리스트에서 길이는 size()
        return result;

    }
}
