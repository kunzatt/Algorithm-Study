// 3 6 7 8 10 12 14 15 18 20

using System;
using System.Linq;

class BOJ_2212
{
    static void Main(string[] args)
    {
        int n = int.Parse(Console.ReadLine());
        int k = int.Parse(Console.ReadLine());
        string[] s = Console.ReadLine().Split();
        int[] arr = s.Select(int.Parse).ToArray();
        Array.Sort(arr);

        int[] interval = new int[n - 1];

        for (int i = 1; i < n; i++)
        {
            interval[i - 1] = arr[i] - arr[i - 1];
        }
        Array.Sort(interval);
        int sum = 0;
        for (int i = 0; i < n - k; i++)
        {
            sum += interval[i];
        }
        Console.WriteLine(sum);
    }
}