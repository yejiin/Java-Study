package exception;

import java.io.*;

public class NonRuntimeExceptionTest {

	public void fileRead1(String fileName) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileName);
			int s = fis.read();
//			fis.close();
		} catch (FileNotFoundException e) {
			System.out.println(fileName + " 파일이 없습니다.");
//			e.printStackTrace();
		} catch (IOException e) {
//			fis.close();
			e.printStackTrace();
		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void fileRead2(String fileName) throws FileNotFoundException {

		FileInputStream fis = new FileInputStream(fileName);

	}
}
