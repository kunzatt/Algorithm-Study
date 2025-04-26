import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val n = br.readLine().toInt();
    val arr = IntArray(n);

    val st = StringTokenizer(br.readLine());

    for (i in 0..n-1 step 1) {
        arr[i] = st.nextToken().toInt();
    }

    for (i in 0..n-1 step 1) {
        if(arr[i]==i+1){
            println(-1);
            return;
        }
    }
    println(1000003);

}