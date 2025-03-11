#include <stdio.h>
#include <math.h>

int power(int num, int exp)
{
    if (exp <= 0)
    {
        return 1;
    }

    return num * power(num, log10(exp));
}

int main()
{
    printf("%d\n", power(2, 0));    // 0    = 0, op: 1
    printf("%d\n", power(2, 1));    // 1    = 1, op: 2
    printf("%d\n", power(2, 10));   // 10   = 2, op: 4
    printf("%d\n", power(2, 11));   // 11   = 3, op: 8
    printf("%d\n", power(2, 100));  // 100  = 4, op: 16
    printf("%d\n", power(2, 101));  // 101  = 5, op: 32
    printf("%d\n", power(2, 110));  // 110  = 4, op: 64
    printf("%d\n", power(2, 111));  // 111  = 7, op: 128
    printf("%d\n", power(2, 1000)); // 1000 = 8, op: 256
    printf("%d\n", power(2, 1001)); // 1001 = 9, op: 512
}
