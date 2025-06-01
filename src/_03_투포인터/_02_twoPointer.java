package _03_투포인터;

// a b c d
// 양쪽의 문자를 비교한 후 같으면 삭제하는데, 연속해서 같은 문자가 등잗하면 함께 삭제

// input
// ab
// output
// ab

// input
// aaabbaa
// 없음

public class _02_twoPointer {
    public static void main(String[] args) {
        System.out.println(solution("ab"));
        System.out.println(solution("aaabbaa"));
        System.out.println(solution("aabcddba"));
    }

    static String solution(String s){
        if(s == null || s.length() == 0) return null;

        int left = 0;
        int right = s.length()-1;

        while(left < right && s.charAt(left) == s.charAt(right)){
            char c = s.charAt(right);

            while(left <= right && s.charAt(left) == c){
                left++;
            }

            while(left <= right && s.charAt(right) == c){
                right--;
            }
        }

        return s.substring(left, right+1);
    }
}
