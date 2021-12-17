package casting;

public class CastingEx2 {

    // byte : 1바이트, int : 4바이트
    public static void main(String[] args) {
        int i = 10;
        byte b = (byte) i;
        System.out.printf("[int -> byte] i=%d -> b=%d%n", i, b);  // [int -> byte] i=10 -> b=10

        i = 300;
        b = (byte) i;
        System.out.printf("[int -> byte] i=%d -> b=%d%n", i, b);  // [int -> byte] i=300 -> b=44 (byte의 크기가 더 작으므로 형변환시 값손실 발생)

        b = 10;
        i = (int) b;  // byte -> int 자동 형변환(형변환 생략 가능)
        System.out.printf("[byte -> int] i=%d -> b=%d%n", i, b);  // [byte -> int] i=10 -> b=10

        b = -2;
        i = (int) b;
        System.out.printf("[byte -> int] i=%d -> b=%d%n", i, b);  // [byte -> int] i=-2 -> b=-2
    }
}
