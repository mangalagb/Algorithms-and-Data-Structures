/*
 * Assume you have a method isSubstring which checks if one word is a 
 * substring of another. Given two strings, s1 and s2, write code to check if s2 is a
 *  rotation of s1 using only one call to isSubstring (i.e., “waterbottle” 
 *  is a rotation of “erbottlewat”).
 */
package chapter1;

class Question8 {

	public boolean isSubstring(String str, String sub) {
		if (str.contains(sub))
			return true;

		return false;
	}

	/*
	 * input: s1 = apple, s2 = pleap ==> apple is a substring of pleappleap A
	 * rotation does not change the ordering of the characters. It just rotates
	 * them.
	 */
	public void isRotation(String s1, String s2) {
		int len = s1.length();
		/* check that s1 and s2 are equal length and not empty */
		if (len == s2.length() && len > 0) {
			/* concatenate s1 and s1 within new buffer */
			String concateneatedString1 = s1 + s1;

			System.out.println(isSubstring(concateneatedString1, s2));
		} else
			System.out.println("false");
	}

	public static void main(String[] args) {
		Question8 q = new Question8();
		q.isRotation("waterbottle", "erbottlewat");
	}
}