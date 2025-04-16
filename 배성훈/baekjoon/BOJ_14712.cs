using System;
using System.Linq;

class Program
{
    private static int _n, _m;
    private static long _full;

    static void Main(string[] args)
    {
        string[] s = Console.ReadLine().Split();
        _n = int.Parse(s[0]);
        _m = int.Parse(s[1]);
        _full = (1 << _n * _m) - 1;
        int count = 0;

        for (long i = 0; i <= _full; i++)
        {
            if (Has2X2(i)) count++;
        }

        Console.WriteLine(count);
    }

    private static bool Has2X2(long num)
    {
        for (int i = 0; i < _n - 1; i++)
        {
            for (int j = 0; j < _m - 1; j++)
            {
                int one = i * _m + j;
                int two = i * _m + j + 1;
                int three = (i + 1) * _m + j;
                int four = (i + 1) * _m + j + 1;

                if ((num & (1 << one)) != 0 &&
                    (num & (1 << two)) != 0 &&
                    (num & (1 << three)) != 0 &&
                    (num & (1 << four)) != 0)
                {
                    return false;
                }
            }
        }

        return true;
    }
}