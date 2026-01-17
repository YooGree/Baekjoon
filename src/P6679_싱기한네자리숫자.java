public class P6679_싱기한네자리숫자 {
    // 메인 함수
    public static void main(String[] args) {
        int start = 1000; // 주어진 범위의 시작값

        // 주어진 범위 내에서 싱기한 네자리 숫자 찾기
        while (start <= 9999) {
            if (isStrangeNumber(start)) {
                // 싱기한 네자리 숫자 출력
                System.out.println(start);
            }
            start++;
        }
    }

    // 싱기한 네자리 숫자 여부 확인하는 함수
    public static boolean isStrangeNumber(int number) {
        int base10Sum = sumOfDigits(number, 10);  // 10진수 자리수 합
        int base12Sum = sumOfDigits(number, 12);  // 12진수 자리수 합
        int base16Sum = sumOfDigits(number, 16);  // 16진수 자리수 합

        // 세 진법의 자리수 합이 모두 같은지 확인
        return (base10Sum == base12Sum && base12Sum == base16Sum);
    }

    // 각 진법별로 자리수 합을 계산하는 함수
    public static int sumOfDigits(int number, int base) {
        int sum = 0;
        while (number > 0) {
            sum += number % base; // 각 자리의 값을 더함
            number /= base; // 다음 자리로 이동
        }
        return sum;
    }
}
