public class StringDemo {
    static String s3; // 有默认值 null

    public static void main(String[] args) {
        // 定义字符串方式一：
        String s = "abcd";
        System.out.println(s);
        // 基本类型 int num = 10;
        // 对象类型 Person per = new Person();

        // 定义字符串方式二：
        String s1 = new String("helloworld");
        System.out.println(s1);

        // 定义字符串方式三：
        String s2 = new String(); // 默认生成的s2是""
        System.out.println(s2.equals(""));
        System.out.println(s2 == null);

        boolean result = isValidateEmail("123456qq.com");
        System.out.println(result == true ? "合法" : "不合法");

        boolean result2 = s1.contains("owo");
        System.out.println(result2);

        testSubstring();
    }

    // 验证邮箱是否合法
    public static boolean isValidateEmail(String email) {
        // 合法情况
        if (email.indexOf("@") != -1 && email.indexOf(".") != -1 && email.indexOf("@") < email.indexOf(".")) {
            return true;
        }
        return false;
    }

    // 验证电话是否合法
    public static void testSubstring() {
        // 029-88888888
//        String phone = "18055555555";
        String phone = "029-12345678";
        if (phone.contains("-")) {
            System.out.println("座机号码");
            // phone.substring(start, end) : [start, end)
            phone = phone.substring(2, 6);
            System.out.println(phone);
        } else {
            System.out.println("手机号码");
        }
    }
}
