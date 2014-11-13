import java.util.List;

public class StringLeeCode {

	public static int atoi(String s) {
		if (s == null || s == "") {
			return 0;
		}
		char[] arr = s.trim().toCharArray();
		if (arr.length == 0) {
			return 0;
		}
		int start = 0;
		boolean isMinus = false;
		if (arr[0] == '-') {
			isMinus = true;
			start++;
		} else if (arr[0] == '+') {
			start++;
		}
		int ret = 0;

		for (int i = start; i < arr.length; i++) {
			if (arr[i] >= '0' && arr[i] <= '9') {
				ret = ret * 10 + arr[i] - '0';

			} else {
				break;
			}
		}
		if(ret < 0) {
			return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		}
		if(isMinus && ret < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		if(!isMinus && ret > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (isMinus) {
			ret = ret * (-1);
		}
		return ret;
	}

	public static void main(String[] args) {
		String case1 = "123";
		System.out.println(atoi("10522545459"));
	}
}
