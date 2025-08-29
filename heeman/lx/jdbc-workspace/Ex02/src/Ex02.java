
public class Ex02 {

	public static void main(String[] args) {
		
		// 1. 배열 생성
        int[] myRandomArray = makeRandomArray();
        System.out.println("1. 100개의 무작위 숫자로 이루어진 배열이 생성되었습니다.");
        // Arrays.toString(myRandomArray)를 사용하면 배열 전체 내용을 쉽게 볼 수 있습니다.
        // System.out.println(Arrays.toString(myRandomArray));

        // Option! - 배열의 수들을 한 줄에 10개씩 출력
        printArrayFormatted(myRandomArray);

        // 2. 인덱스가 홀수인 수들 출력
        printOddIndexedElements(myRandomArray);

        // 3. 배열의 수들의 합을 반환하고 출력
        long sum = getSumOfElements(myRandomArray);
        System.out.println("\n3. 배열의 모든 수의 합: " + sum);

        // 4. 가장 작은 수의 위치(인덱스)를 반환하고 출력
        int minIndex = getIndexOfSmallestNumber(myRandomArray);
        if (minIndex != -1) {
            System.out.println("4. 가장 작은 수의 위치(인덱스): " + minIndex + ", 값: " + myRandomArray[minIndex]);
        } else {
            System.out.println("4. 배열이 비어있습니다.");
        }

        // 5. 3의 배수만을 새로운 List에 복사하여 리턴하고 출력
        List<Integer> multiplesOfThree = getMultiplesOfThree(myRandomArray);
        System.out.println("\n5. 3의 배수만 모은 리스트: " + multiplesOfThree);
        System.out.println("   (총 " + multiplesOfThree.size() + "개의 3의 배수)");
		
	}

	// 1. 1부터 999까지의 100개의 임의의 수로 이루어진 배열을 생성하여 반환하는 함수
    // (기존 makeArray()에서 범위만 1~999로 수정)
    private static int[] makeRandomArray() {
        int[] result = new int[100];
        for (int i = 0; i < 100; i++) {
            result[i] = (int) (Math.random() * 999) + 1; // 1 ~ 999 사이의 숫자
        }
        return result;
    }
    
    // 2. 인덱스가 홀수인 수들을 출력하는 함수
    public static void printOddIndexedElements(int[] arr) {
        System.out.println("\n--- 인덱스가 홀수인 숫자들 ---");
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            // 배열 인덱스는 0부터 시작하므로, 1, 3, 5... 번째 인덱스가 홀수 인덱스입니다.
            if (i % 2 != 0) { // i를 2로 나누었을 때 나머지가 0이 아니면 홀수 인덱스
                System.out.print(arr[i] + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("홀수 인덱스에 해당하는 숫자가 없습니다.");
        }
        System.out.println(); // 줄바꿈
    }
    
    // 3. 배열의 수들의 합을 반환하는 함수
    public static long getSumOfElements(int[] arr) {
        long sum = 0; // 합계가 int 범위를 넘어설 수 있으므로 long 사용
        for (int num : arr) { // 향상된 for 루프 (for-each) 사용
            sum += num;
        }
        return sum;
    }
    
    // 4. 가장 작은 수의 위치(인덱스)를 반환하는 함수
    public static int getIndexOfSmallestNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // 배열이 비어있거나 null인 경우 -1 반환 (오류 표시)
        }

        int minVal = arr[0]; // 첫 번째 요소를 최소값으로 초기화
        int minIndex = 0;    // 첫 번째 인덱스를 최소값의 위치로 초기화

        for (int i = 1; i < arr.length; i++) { // 두 번째 요소부터 비교 시작
            if (arr[i] < minVal) {
                minVal = arr[i]; // 더 작은 값 발견 시 최소값 업데이트
                minIndex = i;    // 최소값의 위치 업데이트
            }
        }
        return minIndex;
    }
    
 // 5. 3의 배수만을 새로운 List에 복사하여 리턴하는 함수 (List Collection API 사용)
    public static List<Integer> getMultiplesOfThree(int[] arr) {
        List<Integer> multiples = new ArrayList<>(); // 3의 배수를 담을 ArrayList 생성
        for (int num : arr) {
            if (num % 3 == 0) { // 숫자가 3으로 나누어 떨어지면 (3의 배수이면)
                multiples.add(num); // 리스트에 추가
            }
        }
        return multiples;
    }
    
    // Option! - 배열의 수들을 한 줄에 10개씩 출력하는 함수, 이때 각 수들은 줄이 맞춰져야 함
    public static void printArrayFormatted(int[] arr) {
        System.out.println("\n--- 배열 내용 (10개씩 정렬) ---");
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d ", arr[i]); // 각 숫자를 4칸 너비로 정렬하여 출력
            if ((i + 1) % 10 == 0) { // 10번째 숫자마다 줄바꿈
                System.out.println();
            }
        }
        System.out.println(); // 마지막 줄바꿈
    }

	
}
