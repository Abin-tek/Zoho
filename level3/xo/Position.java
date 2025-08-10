public class Position {

    protected static int[] calculate(int num, int grid) {
        int[] res = new int[2];

        res[0] = num / grid;
        res[1] = num % grid;

        return res;
    }
}
