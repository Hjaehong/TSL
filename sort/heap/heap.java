import java.util.PriorityQueue;
public class Main {
    public static void main(String[] args) {

        //heap정렬을 구현하기 위한 배열 
        int[] arr ={12,20,23,14,5,4,3};
        // 출력
        System.out.println(" 배열 정렬 전 : ");
        for(int i =0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        // 자바안에 내장되어 있는 우선순위 큐
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        System.out.println("=================");
        System.out.println("heap에 배열 값 대입");
        //정렬하기 위해 배열을 heap으로 지정
        for(int i=0; i<arr.length; i++){
            heap.add(arr[i]);
            System.out.print(heap);
        }
        System.out.println("\n=================");

        // 힙에서 우선순위가 높은 노드를 하나씩 뽑느다.
        for(int i=0; i<arr.length; i++){
            arr[i] = heap.poll();
        }
        System.out.println("정렬 후 배열 : ");
        for(int val : arr){
            System.out.print(val + " ");
        }

    }
}