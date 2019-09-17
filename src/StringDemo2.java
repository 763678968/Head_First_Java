public class StringDemo2 {

    // input: helloworld
    public static int test03(String input, String word) {
        int count = 0;
        String[] strs = new String[input.length()];
        for (int i = 0; i < input.length(); i++) {
            strs[i] = input.substring(i, i+1);
            if (strs[i].equals(word)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(test03("helloworld", "o"));
    }
}
