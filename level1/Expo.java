class Expo {
	
	int power(int num, int exp) {
		if (exp == 0) {
			return 1;
		}
		return num * power(num, /* your code */ );	// replace the comment with required logic
	}
	
  	public static void main(String args[]) {
		System.out.println(new Test().power(2, 11));   // 11 = 3, op: 8
		System.out.println(new Test().power(2, 111));  // 111 = 7, op: 128
	}
}
