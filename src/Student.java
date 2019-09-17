// 有3个学生，每个学生有姓名、2门成绩；计算每个学生的平均分、总分，并按总分降序输出（姓名、总分、平均分）
public class Student {
    String name;
    int javaScore;
    int sqlScore;

    public double getAvg() {
        return getSum() / 2.0;
    }

    public int getSum() {
        return javaScore + sqlScore;
    }
}
