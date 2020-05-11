public class ShortestWord {
    // Solve
//    Simple, given a string of words, return the length of the shortest word(s).
//    String will never be empty and you do not need to account for different data types.
    public static void main(String... args) {
        int x = findShort("bitcoin take over the world maybe who knows perhaps");
        System.out.println(x);
    }

    // 가장 짧은 단어의 문자열의 개수를 return한다.
    public static int findShort(String s) {
        String strArray[] = s.split(" ");

        //비교할 문자열
        int length = strArray[0].length();
        for (int i=0; i<strArray.length; i++) {
            System.out.println("배열 내 문자열의 갯수"+strArray[i].length());
            System.out.println("비교할 문자열"+length);
            if (length > strArray[i].length()) {
                length = strArray[i].length();
            }
        }
        return length;
    }
}
