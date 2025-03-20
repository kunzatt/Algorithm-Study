package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class BOJ_7682 {
    static char[][] ttt;
    static int[] dy={0,1,1};
    static int[] dx={1,0,1};

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        while(true){
            String s=sc.nextLine();
            if(s.equals("end"))return;

            ttt=new char[3][3];
            int idx=0;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    ttt[i][j]=s.charAt(idx++);
                }
            }
            if(!isValid()){
                System.out.println("invalid");
                continue;
            }
            System.out.println("valid");

        }
    }

    private static boolean isValid(){
        int o=0;
        int x=0;
        int oBingo=0;
        int xBingo=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(ttt[i][j]=='O')o++;
                if(ttt[i][j]=='X')x++;
            }
        }
        if(
                (ttt[0][0]=='O'&&ttt[1][0]=='O'&&ttt[2][0]=='O')||
                        (ttt[0][0]=='O'&&ttt[1][1]=='O'&&ttt[2][2]=='O')||
                        (ttt[0][1]=='O'&&ttt[1][1]=='O'&&ttt[2][1]=='O')||
                        (ttt[0][2]=='O'&&ttt[1][2]=='O'&&ttt[2][2]=='O')||
                        (ttt[0][0]=='O'&&ttt[0][1]=='O'&&ttt[0][2]=='O')||
                        (ttt[1][0]=='O'&&ttt[1][1]=='O'&&ttt[1][2]=='O')||
                        (ttt[2][0]=='O'&&ttt[2][1]=='O'&&ttt[2][2]=='O')||
                        (ttt[0][2]=='O'&&ttt[1][1]=='O'&&ttt[2][0]=='O')
        )oBingo++;
        if(
                (ttt[0][0]=='X'&&ttt[1][0]=='X'&&ttt[2][0]=='X')||
                        (ttt[0][0]=='X'&&ttt[1][1]=='X'&&ttt[2][2]=='X')||
                        (ttt[0][1]=='X'&&ttt[1][1]=='X'&&ttt[2][1]=='X')||
                        (ttt[0][2]=='X'&&ttt[1][2]=='X'&&ttt[2][2]=='X')||
                        (ttt[0][0]=='X'&&ttt[0][1]=='X'&&ttt[0][2]=='X')||
                        (ttt[1][0]=='X'&&ttt[1][1]=='X'&&ttt[1][2]=='X')||
                        (ttt[2][0]=='X'&&ttt[2][1]=='X'&&ttt[2][2]=='X')||
                        (ttt[0][2]=='X'&&ttt[1][1]=='X'&&ttt[2][0]=='X')
        )xBingo++;


        if (x<o||x>o+1) return false;
        if (oBingo>0&&xBingo>0) return false;
        if (oBingo>0&&x!=o) return false;
        if (xBingo>0&&x!=o+1) return false;
        if (x==5&&o==4&&oBingo == 0&&xBingo==0) return true;
        return oBingo>0||xBingo>0;
    }
}
