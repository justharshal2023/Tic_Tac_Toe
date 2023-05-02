import java.util.Random;
import java.util.Scanner;
public class Tic_Tac_Toe {
    public static boolean end(char[][] arr){
        if(arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[1][1]!='-'){
            return true;
        }else if(arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2] && arr[1][1]!='-'){
            return true;
        }else if(arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2] && arr[0][1]!='-'){
            return true;
        }else if(arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2] && arr[1][1]!='-'){
            return true;
        }else if(arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2] && arr[2][1]!='-'){
            return true;
        }else if(arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0] && arr[1][0]!='-'){
            return true;
        }else if(arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] && arr[1][1]!='-'){
            return true;
        }else if(arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] && arr[1][2]!='-'){
            return true;
        }
        return false;
    }
    public static void check1(char[][] arr, String c) {
        if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[1][1] != '-') {
            print(arr);
            System.out.println( c + " WON");
            return;
        } else if (arr[2][0] == arr[1][1] && arr[1][1] == arr[0][2] && arr[1][1] != '-') {
            print(arr);
            System.out.println(c +" WON");
            return;
        } else if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2] && arr[0][1] != '-') {
            print(arr);
            System.out.println(c+" WON");
            return;
        } else if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2] && arr[1][1] != '-') {
            print(arr);
            System.out.println(c +" WON");
            return;
        } else if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2] && arr[2][1] != '-') {
            print(arr);
            System.out.println(c+" WON");
            return;
        } else if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0] && arr[1][0] != '-') {
            print(arr);
            System.out.println(c+" WON");
            return;
        } else if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] && arr[1][1] != '-') {
            print(arr);
            System.out.println(c+" WON");
            return;
        } else if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] && arr[1][2] != '-') {
            print(arr);
            System.out.println(c+" WON");
            return;
        } else {
            print(arr);
            return;
        }
    }
    public static void print(char[][] arr){
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(arr[i][j] + "|");
            }
            System.out.println();
        }
    }
    public static void main(String[]args){
        char[][] arr = new char[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                arr[i][j]= '-';
            }
        }
        Scanner s = new Scanner(System.in);
        System.out.println("Enter mode of play" + "\n" + "for Dumb A.I. : Press 0" + "\n" + "for Multiplayer : Press 1");
        int nn = s.nextInt();

        if (nn == 0) {
            print(arr);
            System.out.println("Input Example : row number <space> column number      both rows and columns are from 0 to 2 (ends inclusive) ");
            System.out.println("Player : o" +"\n"+"Dumb A.I. : x");

            for (int i = 0; i < 9; ) {
                System.out.println("Player's Chance");
                for (int z1 = 3; z1 > 0; ) {
                    int q1 = s.nextInt();
                    int q2 = s.nextInt();
                    if (q1 >= 0 && q1 < 3 && q2 >= 0 && q2 < 3 && arr[q1][q2] == '-') {

                        arr[q1][q2] = 'o';
                        check1(arr,"Player");
                        i++;
                        break;
                    } else {
                        z1--;
                        System.out.println("Invalid Input " + z1 + " moves remaining for Player");
                    }

                }
                if (end(arr)) {
                    break;
                } else if (i >= 9) {
                    print(arr);
                    System.out.println("Game Over No one WON");
                    break;
                }

                Random r = new Random();

                for(int j= 0;j<1000;j++){
                    int n1 = r.nextInt(3);
                    int n2 = r.nextInt(3);
                    if (arr[n1][n2] == '-') {

                        arr[n1][n2] = 'x';
                        System.out.println("Dumb A.I. chose "+ n1 +" "+ n2);
                        check1(arr, "A.I.");
                        i++;
                        break;
                    }
                }if (end(arr)) {
                    break;
                } else if (i >= 9) {
                    print(arr);
                    System.out.println("Game Over No one WON");
                    break;
                }
            }
        }else if(nn==1){
            print(arr);
            System.out.println("Player 1 is o");
            System.out.println("Player 2 is x");
            System.out.println("Input Example : row number <space> column number      both rows and columns are from 0 to 2 (ends inclusive) ");

            for(int i=0;i<9;) {
                System.out.println("Player 1's Chance");
                for(int z1=3;z1>0;){
                    int q1 = s.nextInt();
                    int q2 = s.nextInt();
                    if(q1>=0 && q1<3 && q2>=0 && q2<3 && arr[q1][q2]=='-'){

                        arr[q1][q2] = 'o';
                        check1(arr,"Player1");
                        i++;
                        if(i>=9){
                            print(arr);
                            System.out.println("Game Over No one WON");
                            break;
                        }
                        break;
                    }else {
                        z1--;
                        System.out.println("Invalid Input " + z1 + " moves remaining for Player1");
                    }

                }
                if(end(arr)){
                    break;
                }else if(i==9){
                    print(arr);
                    System.out.println("Game Over No one WON");
                    break;
                }

                System.out.println("Player 2's Chance");

                for(int z2=3;z2>0;){

                    int r1 = s.nextInt();
                    int r2 = s.nextInt();
                    if(r1>=0 && r1<3 && r2>=0 && r2<3 && arr[r1][r2]=='-'){

                        arr[r1][r2] = 'x';
                        check1(arr,"Player2");
                        i++;
                        break;
                    }else{
                        z2--;
                        System.out.println("Invalid Input " + z2 + " moves remaining for Player2");
                    }
                }
                if(end(arr)){
                    break;
                }else if(i==9){
                    print(arr);
                    System.out.println("Game Over No one WON");
                    break;
                }
            }
        }
    }
}
