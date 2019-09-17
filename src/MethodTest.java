import java.util.Scanner;

public class MethodTest {

    public void myInput(int[] students) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入第一个学生成绩：");
        students[0] = input.nextInt();
        System.out.println("请输入第二个学生成绩：");
        students[1] = input.nextInt();
        System.out.println("请输入第三个学生成绩：");
        students[2] = input.nextInt();
    }

    public int calcMax(int[] students) {
        int max = students[0];
        for (int i = 1; i < students.length; i++) {
            if (max < students[i]) {
                max = students[i];
            }
        }
        return max;
    }

    public int calcSum(int[] students) {
        int sum = 0;
        for (int student : students) {
            sum += student;
        }
        return sum;
    }

    public double calcAvg(int[] students) {
        int sum = calcSum(students);
        return sum * 1.0 / students.length;
    }

    public static void main(String[] args) {
        int[] students = new int[3]; // {0, 0, 0}

        MethodTest test = new MethodTest();
        test.myInput(students);

        double avg = test.calcAvg(students);
        int sum = test.calcSum(students);
        int max = test.calcMax(students);
        System.out.println("平均分：" + avg + "总分：" + sum + "最高分：" + max);
    }
}
