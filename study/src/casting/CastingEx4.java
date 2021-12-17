package casting;

public class CastingEx4 {

    public static void main(String[] args) {
        int i = 91234567;
        float f = (float) i;
        int i2 = (int) f;

        double d = (double) i;
        int i3 = (int) d;

        float f2 = 1.666f;
        int i4 = (int) f2;

        System.out.printf("i = %d\n", i);  // i = 91234567
        System.out.printf("f = %f i2 = %d\n", f, i2);  // f = 91234568.000000 i2 = 91234568  (int를 float로 변환할 때 정밀도 차이에 의해 오차 발생. int의 정밀도가 더 큼, float의 정밀도 약 7자리, int의 정밀도 약 10자리)
        System.out.printf("d = %f i3 = %d\n", d, i3);  // d = 91234567.000000 i3 = 91234567  (10진수로 8자리 이상의 값을 실수형으로 변환할 때는 double로 형변환해야 오차 발생x, double의 정밀도 약 15자리)
        System.out.printf("(int) %f = %d\n", f2, i4);  // (int) 1.666000 = 1

        int ii = 1234;
        float ff = (float) ii;
        double dd = (double) ii;
        System.out.printf("ii = %d, ff = %f, dd = %f", ii, ff, dd);  // ii = 1234, ff = 1234.000000, dd = 1234.000000

    }
}
