import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Boolean canDivide=false;
        int input=scanner.nextInt();
        int maxTry=input/5;
        int fiveKgCount=maxTry;
        int threeKgCount=0;

        for(int i = 1; i<=maxTry; i++) {
            if((input-5*fiveKgCount)%3==0) {
                canDivide=true;
                break;
            }
            fiveKgCount--;
        }

        if(canDivide==true) {
            threeKgCount=(input-5*fiveKgCount)/3;
            System.out.print(fiveKgCount+threeKgCount);
        }
        else if(input%3==0) {
            System.out.print(input/3);
        }
        else {
            System.out.print("-1");
        }

    }
}