using System.Reflection.PortableExecutable;

public class Program
{
    public static void Main(string[] args)
    {
        var minsik = new[]
        {
            "a", "b", "k", "d", "e", "g", "h", "i", "l", "m", "n", "ng", "o", "p", "r", "s", "t", "u", "w", "y"
        };

        var minsikMap = minsik
            .Select((val, idx) => new { val, idx })
            .ToDictionary(pair => pair.val, pair => pair.idx);

        var n = int.Parse(Console.ReadLine());
        var arr = new List<string>();
        for (int i = 0; i < n; i++)
        {
            arr.Add(Console.ReadLine());
        }

        arr.Sort((x, y) =>
        {
            var len = Math.Min(x.Length, y.Length);
            var xIdx = 0;
            var yIdx = 0;

            while (xIdx < x.Length && yIdx < y.Length)
            {
                string xChar, yChar;
                int xCharLen = 1, yCharLen = 1;
                if (xIdx + 1 < x.Length && x.Substring(xIdx, 2).Equals("ng"))
                {
                    xChar = "ng";
                    xCharLen = 2;
                }
                else
                {
                    xChar = x[xIdx].ToString();
                }
                if (yIdx + 1 < y.Length && y.Substring(yIdx, 2).Equals("ng"))
                {
                    yChar = "ng";
                    yCharLen = 2;
                }
                else
                {
                    yChar = y[yIdx].ToString();
                }

                var xOrder = minsikMap[xChar];
                var yOrder = minsikMap[yChar];
                if (xOrder != yOrder)
                {
                    return xOrder.CompareTo(yOrder);
                }

                xIdx += xCharLen;
                yIdx += yCharLen;
            }

            return x.Length.CompareTo(y.Length);
        });

        for (var i = 0; i < n; i++)
        {
            Console.WriteLine(arr[i]);
        }
    }
}