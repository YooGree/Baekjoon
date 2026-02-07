import java.util.Scanner;

public class P21866_추첨을통해커피를받자 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] originalScore = {100, 100, 200, 200, 300, 300, 400, 400, 500};
        int[] studentScore = new int[9];
        int tot=0, count=0;
        for(int i=0; i<originalScore.length; i++){
            studentScore[i]= sc.nextInt();
            tot+= studentScore[i];
            if(studentScore[i] > originalScore[i]){
                count++;
            }else{
                count+=0;
            }

        }
        if(tot < 100)
            System.out.println("none");
        else{
            if(count > 0)
                System.out.println("hacker");
            else
                System.out.println("draw");
        }
        sc.close();
    }
}
