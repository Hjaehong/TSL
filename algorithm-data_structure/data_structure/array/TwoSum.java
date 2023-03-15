package data_structure.array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

        int arr[] = {2,7,11,15};
        int target = 9;
        int[] result = sum(arr, target);
        System.out.println(Arrays.toString(result));
    }

    
    public static int[] sum(int[] nums, int target) {
        //TODO Nums에서 두 수를 더하여 target이 되는 인덱스를 찾아라
        // 간단한 방법 : 이중 for문을 이용해 모든 경우의 수 확인
        // 효율적인 방법 : HashMap을 이용하여 해당하는 값이 있는지 확인

        /**
         * 1. HashMap은 key, value로 이루어져 있고 key로 value를 검색할 수 있다
         * 시간 복잡도가 O(n)이다.
         */
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            // 2. 배열의 인덱스 요소와 찾을려는 값을 뺀 값(complement)가 있는지 확인한다.
            int complement = target - nums[i];
            // containsKey는 hash table에서 값이 존재하는지 확인한다.
            if(map.containsKey(complement)) {
                // 값이 있다면 반환
                return new int[] {
                        // 조건문에서 hashmap 내부에 값이 있는지 확인
                        map.get(complement), i
                };
            }
            /* 3. 값이 없다면 해당 값을 넣어 준다.
             * nums[0]의 값을 key로 인덱스를 value로 넣어준다.
             * hashMap[ 2 , 0 ] 형태로 저장
             */
            map.put(nums[i], i);

        }
        throw new IllegalArgumentException("배열에서 조합할 수 없는 값입니다.");
    }

}
