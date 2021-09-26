package io;

import java.io.*;

public class BuffredReaderTest {
	public static void main(String[] args) {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("읽을 파일 이름 : ");
		BufferedReader fin = null;
		FileWriter fout = null;
		try {
			String fileName = in.readLine();
			System.out.println("파일 이름 : " + fileName);
			fin = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

//			FileWriter fout = new FileWriter("d:\\iotest.txt");
			fout = new FileWriter(new File("d:\\iotest.txt"));
			String str = null;
			while ((str = fin.readLine()) != null) {
				System.out.println(str);
				fout.write(str + "\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (fout != null)
					fout.close();
				if (fin != null)
					fin.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
