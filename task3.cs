using System;

class Program
{
    static int Diff(int a, int b) => a > b ? a - b : b - a;

    static int Prod(int n)
    {
        int res = 1;
        while (n > 0)
        {
            res *= n % 10;
            n /= 10;
        }
        return res;
    }

    static int SumDigits(int n)
    {
        int res = 0;
        while (n > 0)
        {
            res += n % 10;
            n /= 10;
        }
        return res;
    }

    static void Main()
    {
        Console.Write("Enter the number: ");
        if (int.TryParse(Console.ReadLine(), out int num) && num > 0)
        {
            int summary = SumDigits(num);
            int product = Prod(num);
            Console.WriteLine($"{summary} {product} {Diff(summary, product)}");
        }
        else
        {
            Console.WriteLine("Number is not natural");
        }
    }
}