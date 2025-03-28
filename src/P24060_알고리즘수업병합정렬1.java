import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P24060_알고리즘수업병합정렬1 {
    int[] A; //입력받은 배열
    static int[] tmp; //정렬 후 저장하는 배열
    static int result = -1; //결과 저장 (실패시 -1)
    static int cnt = 0; //저장 횟수 누적 저장
    static int K; // 저장 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 배열의 크기
        K = Integer.parseInt(st.nextToken()); // 저장 횟수

        int[] A = new int[N];
        tmp = new int[N]; //오름차순 정렬해서 저장할 배열 초기화

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){ //배열의 요소 입력 받기
            A[i] = Integer.parseInt(st.nextToken());
        }

        merge_sort(A, 0, N-1); //처음 시작점 0, 마지막 인덱스 : N-1(배열은 0부터 시작하기 때문)

        System.out.println(result);
    }

    //오름차순 정렬하는 메소드
    static void merge_sort(int A[], int p, int r){
        if(cnt > K) return; //저장 횟수가 진행 횟수보다 넘어가게 되면 더이상 분해 or 병합 진행X
        if(p < r){
            int q = (p+r)/2; //중간으로 쪼갠다.
            merge_sort(A, p, q);   //전반부 정렬
            merge_sort(A,q+1, r); //후반부 정렬
            merge(A, p, q, r); //병합
        }
    }

    //병합하는 메소드
    /*
     [파라미터]
     p : 시작 점 (인덱스)
     q : 중간 점 (인덱스) _ 쪼갠 배열의 첫번재 배열
     r : 마지막 점 (인덱스)
    */
    static void merge(int Array[], int p, int q, int r){
        int i = p;
        int j = q + 1; //쪼갠 배열(2번째) 시작 인덱스
        int t = 0;

        //시작 인덱스가 중간 인덱스(1번쨰)보다 작고,
        //중간인덱스(2번째)가 마지막인덱스보다 작을 경우 반복
        while(i <= q && j <= r){
            if(Array[i] < Array[j]){ //만약 Array[i](=앞의 값)이/가 Array[j](=뒤의 값)보다 작을 경우
                tmp[t++] = Array[i++]; //작은 값을 넣어주고
            }
            else{//만약 Array[i](=앞의 값)이/가 Array[j](=뒤의 값)보다 크거나 같을 경우
                tmp[t++] = Array[j++]; //작은 값이 Array[j]이므로 작은 값을 차근차근 쌓는다.
            }
        }

        //다 정렬하고도 남은 경우
        while(i <= q){ //왼쪽 배열이 남은 경우
            tmp[t++] = Array[i++]; //tmp배열에 저장하는 정수
        }

        while(j <= r){ //오른쪽 배열이 남은 경우
            tmp[t++] = Array[j++]; //tmp배열에 저장하는 정수
        }

        i = p;
        t = 0;
        while(i <= r){ //결과를 배열 A에 저장한다. i(시작), r(끝)
            cnt++;

            if(cnt == K){ //저장횟수가 같다면
                result = tmp[t]; //해당 증가한 만큼의 t인덱스의 값을 result변수에 담고
                break;
            }

            Array[i++] = tmp[t++]; //A에 순서대로 정렬된 값을 저장
        }
    }
}
