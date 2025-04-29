using System.Text;

public class Program
{
    internal static StringBuilder Result;

    internal class Trie
    {
        internal TrieNode Root = new TrieNode();
        private StringBuilder _str = new StringBuilder();

        public void Insert(string s)
        {
            var cur = Root;
            _str.Clear();
            var written = false;

            foreach (var c in s)
            {
                var idx = c - 'a';
                if (cur.Node[idx] == null)
                {
                    if (!written)
                    {
                        _str.Append(c);
                        Result.Append(_str).Append('\n');
                        written = true;
                    }

                    cur.Node[idx] = new TrieNode();
                }
                else
                {
                    if (!written)
                    {
                        _str.Append(c);
                    }
                }

                cur = cur.Node[idx];
            }

            cur.IsEnd++;
            if (!written)
            {
                Result.Append(_str);
                if (cur.IsEnd > 1)
                    Result.Append(cur.IsEnd);
                Result.Append('\n');
            }
        }
    }

    internal class TrieNode
    {
        internal TrieNode[] Node = new TrieNode[26];
        internal int IsEnd;
    }

    public static void Main(string[] args)
    {
        var sr = new StreamReader(Console.OpenStandardInput());
        var sw = new StreamWriter(Console.OpenStandardOutput());
        Result = new StringBuilder(1024 * 1024);
        var n = int.Parse(sr.ReadLine());
        var t = new Trie();
        for (var i = 0; i < n; i++)
        {
            t.Insert(sr.ReadLine());
        }

        sw.Write(Result);
        sw.Flush();
    }
}