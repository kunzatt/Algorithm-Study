import java.io.*;
import java.util.*;

public class Main_7682 {

    static void answerInvalid() {
        System.out.println("invalid");
    }

    static void answerValid() {
        System.out.println("valid");
    }

    static boolean isWin(char[] board, char player) {
        if (board[0] == player && board[1] == player && board[2] == player) return true;
        if (board[3] == player && board[4] == player && board[5] == player) return true;
        if (board[6] == player && board[7] == player && board[8] == player) return true;

        if (board[0] == player && board[3] == player && board[6] == player) return true;
        if (board[1] == player && board[4] == player && board[7] == player) return true;
        if (board[2] == player && board[5] == player && board[8] == player) return true;

        if (board[0] == player && board[4] == player && board[8] == player) return true;
        if (board[2] == player && board[4] == player && board[6] == player) return true;

        return false;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String temp = br.readLine();
            if (temp.equals("end")) break;

            int ocount = 0;
            int xcount = 0;
            boolean hasEmpty = false;
            char[] board = temp.toCharArray();

            for (int i = 0; i < 9; i++) {
                if (board[i] == 'X') xcount++;
                else if (board[i] == 'O') ocount++;
                else if (board[i] == '.') hasEmpty = true;
            }

            boolean xWin = isWin(board, 'X');
            boolean oWin = isWin(board, 'O');

            if (xcount != ocount && xcount != ocount + 1) {
                answerInvalid();
                continue;
            }
            if (xWin && xcount != ocount + 1) {
                answerInvalid();
                continue;
            }
            if (oWin && xcount != ocount) {
                answerInvalid();
                continue;
            }
            if (xWin && oWin) {
                answerInvalid();
                continue;
            }
            if (!xWin && !oWin && hasEmpty) {
                answerInvalid();
                continue;
            }
            answerValid();
        }
    }
}