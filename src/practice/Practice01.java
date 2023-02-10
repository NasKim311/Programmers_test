package practice;

public class Practice01 {

	public String solution(String s, String skip, int index) {

//		5 ≤ s의 길이 ≤ 50
//		1 ≤ skip의 길이 ≤ 10
//		s와 skip은 알파벳 소문자로만 이루어져 있습니다.
//		skip에 포함되는 알파벳은 s에 포함되지 않습니다.
//		1 ≤ index ≤ 20

		// 's' 와 'skip' 은 알파벳 소문자만 가능 -> 97 <= s, skip <= 122

		char[] s_letters = s.toCharArray(); // 's'를 한글자씩 쪼갠 후 배열에 할당
		char[] skip_letters = skip.toCharArray(); // 'skip'을 한글자씩 쪼갠 후 배열에 할당

		char[] s_lettersPlusIndex = new char[s_letters.length]; // 's'의 글자에 index를 더한 값을 할당할 배열 선언

		String answer = "";

		for (int i = 0; i < s_letters.length; i++) {

//			answer += s_letters[i];
//			answer += (char) ((int) s_letters[i] + index);
			s_lettersPlusIndex[i] = (char) (s_letters[i] + index);

			for (int j = 0; j < skip_letters.length; j++) {

				if (skip_letters[j] > s_letters[i] && skip_letters[j] < s_lettersPlusIndex[i]) {

					s_lettersPlusIndex[i] = (char) (s_lettersPlusIndex[i] + 1);

				}
			}

			if (s_lettersPlusIndex[i] > 122) {
				answer +=  (char)(96 + (s_lettersPlusIndex[i] -122));
			}else {
				answer += s_lettersPlusIndex[i];
			}

		}

		return answer;

	} // solution method

	public static void main(String[] args) {

		Practice01 pr = new Practice01();

		System.out.println(pr.solution("z", "abcd", 1));

	} // main method

} // Practice01 class
