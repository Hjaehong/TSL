import java.util.PriorityQueue;
/**
 * 문제 : K번째 작은 수 찾기
 * 입력: 리스트 nums: n개의 정수로 이루어진 리스트 (1 <= n <= 10^5, -10^9 <= nums[i] <= 10^9)
 *      정수 k: 찾고자 하는 작은 수의 순위 (1 <= k <= n)
 * 출력: K번째 작은 수*/
public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        int[] num1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(main.heap(num1, k1));
        int[] num2 = {5, 3, 1, 7, 9, 4};
        int k2 = 4;
        System.out.println(main.heap(num2, k2));

    }


   public int heap(int[] nums, int k) {
        // 우선순위 큐, 힙은 우선순위 큐를 베이스로 한다.
       // PriorityQueue는 최소로 정렬
       PriorityQueue<Integer> heap = new PriorityQueue<>();
        // 힙에 배열 요소 삽입
       for(int num : nums) {
           heap.add(num);
       }
       // 최소 힙으로 정렬되어 있으므로 poll로 하나씩 뺀다
       for(int i = 0; i < k-1; i++) {
           heap.poll();
           
       }

       return heap.poll();
        
   }
}