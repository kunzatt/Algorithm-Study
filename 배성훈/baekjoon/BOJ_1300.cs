/**
 * n=3
 * 1 2 3
 * 2 4 6
 * 3 6 9
 *
 * n=4
 * 1 2 3 4
 * 2 4 6 8
 * 3 6 9 12
 * 4 8 12 16
 *
 *
 * n=5
 * 1 2 3 4 5
 * 2 4 6 8 10
 * 3 6 9 12 15
 * 4 8 12 16 20
 * 5 10 15 20 25
 */
public class Program
{
    public static void Main(string[] args)
    {
        var n = long.Parse(Console.ReadLine());
        var k = long.Parse(Console.ReadLine());

        var left = 1L;
        var right = n * n;
        while (left <= right)
        {
            var mid = (left + right) / 2;
            var count = 0L;
            for (int i = 1; i <= n; i++)
            {
                count += Math.Min(n, mid / i);
            }

            if (count < k)
            {
                left = mid + 1;
            }
            else
            {
                right = mid - 1;
            }
            
        }
        Console.WriteLine(left);
    }
}