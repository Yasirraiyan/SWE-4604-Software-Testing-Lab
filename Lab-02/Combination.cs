using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Lab_2
{
    public class Combination
    {
        public long combination(double n, double r)
        {
            if (n != (int)n || r != (int)r)
            {
                throw new Exception("Inputs must be integers");
            }
            return combination((int)n, (int)r);
        }
        public long calculateCombination(long n, long r)
        {
            if (n <= 0)
            {
                throw new Exception("The Value of n can not be Zero or -ve");
            }
            else if (n > 16 || r > 15)
            {
                throw new Exception("Out of range");
            }
            else if (r > n)
            {
                throw new Exception("r cannot be greater than n");
            }

            else
            {
                return Factorial(n) / (Factorial(r) * Factorial(n - r));
            }
        }

        public long Factorial(long x)
        {
            long result = 1;
            for (long i = 1; i <= x; i++)
            {
                result = result * i;
            }
            return result;
        }
    }
}
