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

    // input: helloworld "low" 判断一个字符串中，某个子字符串出现的次数
    public static int test04(String input, String word) {
//        int position = input.indexOf(word);
//        System.out.println(position);
        int count = 0;
        while(input.indexOf(word) != -1) {
            count++;
            input = input.substring(input.indexOf(word) + 1);
        }
        return count;
    }

    public static void test05() {
        String str = "helloworld";
        int position = str.indexOf("llo");
        System.out.println(position);

        // 根据位置查找字符
        char c = str.charAt(2);
        System.out.println(c);

        // replace
        System.out.println(str);
        str = str.replace('l', 'y');
        System.out.println(str);

        str = str.replace("he", "eh");
        System.out.println(str);
    }

    public static void main(String[] args) {
//        System.out.println(test03("helloworld", "o"));
//        System.out.println(test04("helloworldllo", "llo"));
        test05();
    }
}
