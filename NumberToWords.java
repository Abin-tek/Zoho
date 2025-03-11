public class NumberToWords {
    private static final String[] units = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
            "Seventeen", "Eighteen", "Nineteen" };

    private static final String[] tens = { "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
            "Ninety" };

    public static String convert(long num) {
        if (num == 0)
            return "Zero";

        return convertHelper(num).trim();
    }

    private static String convertHelper(long num) {
        if (num < 20) {
            return units[(int) num];
        } else if (num < 100) {
            return tens[(int) (num / 10)] + " " + units[(int) (num % 10)];
        } else if (num < 1000) {
            return units[(int) (num / 100)] + " Hundred " + convertHelper(num % 100);
        } else if (num < 1_000_000) {
            return convertHelper(num / 1000) + " Thousand " + convertHelper(num % 1000);
        } else if (num < 1_000_000_000) {
            return convertHelper(num / 1_000_000) + " Million " + convertHelper(num % 1_000_000);
        } else {
            return convertHelper(num / 1_000_000_000) + " Billion " + convertHelper(num % 1_000_000_000);
        }
    }

    public static void main(String[] args) {
        long number = 1234567890;
        System.out.println("Number in words: " + convert(number));
    }
}