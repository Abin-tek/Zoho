class Test {
    char[] letters = new char[] { 'a', 'b', 'c' };
    int index = 0;
    String[] res;

    public String getHappyString(int n, int k) {
        int length = 3 * (int) Math.pow(2, n - 1);
        res = new String[length];
        generate(n, new StringBuilder());

        return res[k - 1];
    }

    private void generate(int n, StringBuilder str) {
        int len = str.length();
        if (len == n) {
            res[index++] = str.toString();
            return;
        }

        for (char c : letters) {
            if (len == 0 || c != str.charAt(len-1)) {
                str.append(c);
                generate(n, str);
                str.replace(len, len+1, "");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test().getHappyString(3, 9));
    }
}