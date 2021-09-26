package abstracttest.instance;

public class ProcessTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Runtime r = Runtime.getRuntime(); // constructor is not visible --> 생성자가 private
		try {
			Process p = r.exec("calc"); // 프로세스 관리 --> 계산기 실행
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
