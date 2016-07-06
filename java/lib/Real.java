package lib;

/**
 * Created by ted on 12/19/14.
 */
public class Real
{
    private final int numerator, denominator;

    public Real(int num, int denom)
    {
        int gcd = GCD(num, denom);
        numerator = num / gcd;
        denominator = denom / gcd;
    }

    public Real(int unit)
    {
        numerator = unit;
        denominator = 1;
    }

    public Real add(Real r)
    {
        int newNum = numerator * r.denominator;
        newNum += r.numerator * denominator;
        return new Real(newNum, denominator * r.denominator);
    }

    public Real subtract(Real r)
    {
        int newNum = numerator * r.denominator;
        newNum -= r.numerator * denominator;
        return new Real(newNum, denominator * r.denominator);
    }

    public Real divide(Real r)
    {
        return new Real(numerator * r.denominator, denominator * r.numerator);
    }

    public Real multiply(Real r)
    {
        return new Real(numerator * r.numerator, denominator * r.denominator);
    }

    private static int GCD(int i, int j)
    {
        return (j == 0) ? i : GCD(j, i % j);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        Real other = (Real) obj;
        if (numerator == 0 && other.numerator == 0)
        {
            return true;
        }
        if (denominator != other.denominator)
        {
            return false;
        }
        if (numerator != other.numerator)
        {
            return false;
        }
        return true;
    }

    public String toString()
    {
        if (denominator == 1 || numerator == 0)
        {
            return numerator + "";
        }
        return numerator + "/" + denominator;
    }

    public static Real parseReal(String value)
    {
        if (value.contains("/"))
        {
            String[] frac = value.split("/");

            return new Real(Integer.parseInt(frac[0]), Integer.parseInt(frac[1]));
        }

        return new Real(Integer.parseInt(value));
    }

    public boolean greaterThan(int threshold)
    {
        return ((double)numerator)/((double)denominator) > threshold;
    }
}
