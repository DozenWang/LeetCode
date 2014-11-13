
public class ReverseString {
	 public static String reverseWords(String s) {
		 String[] tmp = s.split(" ");
		 StringBuilder stringBuilder = new StringBuilder();
		 for(int i = tmp.length - 1; i >= 0; i--) {
			 if("".equals(tmp[i]) || " ".equals(tmp[i])) {
				 continue;
			 }
		     stringBuilder.append(tmp[i].trim() + " ");
		 }
		 return stringBuilder.toString().trim();
	 }

//	 public static void main(String[] args) {
//		 String s = "  a  b";
//		 String ret = reverseWords(s);
//		 System.out.println(ret);
//	 }
}
