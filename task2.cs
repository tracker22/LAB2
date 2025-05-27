using System;
using System.Collections.Generic;
using System.Linq;

class Program
{
    static List<string> FindUnique(List<string> v)
    {
        return v.Distinct().ToList();
    }

    static string Format(string s)
    {
        var result = new System.Text.StringBuilder();
        bool seenAt = false;
        bool seenStar = false;
        foreach (char c in s)
        {
            if (c == '@') seenAt = true;
            if (!seenAt)
            {
                if (c == '*') { seenStar = true; continue; }
                if (seenStar) continue;
                if (c == '.') continue;
            }
            result.Append(c);
        }
        return result.ToString();
    }

    static bool IsAllowed(string s)
    {
        char[] notAllowedChars = { '&', '=', '+', '-', '_', '<', '>', ',', '\'' };
        if (string.IsNullOrEmpty(s) || s[0] == '.') return false;
        if (!s.Contains('@')) return false;

        int atIndex = s.IndexOf('@');
        if (atIndex < 6 || atIndex > 30) return false;

        foreach (char c in s.Substring(0, atIndex))
        {
            if (notAllowedChars.Contains(c)) return false;
        }

        if (s.LastIndexOf('.') <= atIndex || !s.Contains('.')) return false;
        return true;
    }

    static void Main()
    {
        var v = new List<string> { ".555555@.", "1111.111@mail.ru", "11111111@.mailru", "1111111@.mailru", "11111111@.mailru" };
        var filtered = v.Where(IsAllowed).Select(Format).ToList();
        if (filtered.Count == 0) Console.WriteLine("No unique emails");
        else Console.WriteLine(FindUnique(filtered).Count);
    }
}