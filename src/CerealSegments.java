import java.util.*;
import java.util.stream.Collectors;

public class CerealSegments {
    public static void main(String[] args) {

        System.out.println("hello world");
    }

    public void segment(int x, int[] arr) {
        List<Integer> resultList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        List<Integer> resultList2 = new ArrayList<>();
        // 리스트로 바꼈고..
        int[] arr2;
        int min, max, arr2Min, beforeMin;
        if (x == 1) {
          max = Collections.max(resultList);
        } else {
          // 받아온 배열의 갯수만큼 for문을 돌린다.
          // for 문을 돌리면서 배열을 갯수만큼 카피해 그 중 최솟값을 찾는다
          // 그 최소값을 가져오면서, 최대값을 찾는다.
            min = Collections.min(resultList);

            // 0, 1, 2, 3, 4, 5
            for (int i=0; i <= arr.length; i++) {
                // 복사한 배열 내에서 최소값을 찾는다.
                // 복사한 배열은 i번쨰부터, i+x를 복사한거다.
                // 예를들면 end index는 = 0+1 1+1 2+1 더해져간다
                arr2 = Arrays.copyOfRange(arr, i,i + x);

//                arr2.sort();
                min = arr2[0];
                resultList2.add(min);

//                if () {
//                    break;
//                }
                // 3
                // 24568
                // [2,4,5] [
                // [1, 2, 3] [2,3,1] [3,1,2]


//                for (int j=0; j < arr2.length; j++) {
//
//                    if (min > ) {
//
//                    }
//                }

            }

           // 배열을 복사해서 만들어야한다
           // 배열의 갯수는

        }

    }

//    public
}

