import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val arr = Array(16, { IntArray(16) })
    while (true) {
        val s=br.readLine();
        if (s.isNullOrEmpty()) {
            println(arr[15][15]);
            return;
        }
        val st = s.split(" ");
        val w=st[0].toInt();
        val b=st[1].toInt();
        for(i in 15 downTo 0){
            for(j in 15 downTo 0){
                if(i!=0) arr[i][j]=max(arr[i][j],arr[i-1][j] + w);
                if(j!=0) arr[i][j]=max(arr[i][j],arr[i][j-1] + b);
            }
        }
    }
}