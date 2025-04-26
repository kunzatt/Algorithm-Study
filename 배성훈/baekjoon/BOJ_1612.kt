import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger
import java.util.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`));
    val n = br.readLine().toLong();
    var mod=1L%n;
    var length=1;
    val visited=HashSet<Long>();

    while (mod!=0L) {
        if(visited.contains(mod)){
            println(-1);
            return;
        }
        visited.add(mod);
        mod=(mod*10+1)%n;
        length++;
    }
    println(length);
}