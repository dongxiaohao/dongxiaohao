package io_test;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
 
public class zhijieliu_in_test {
 
	public static void main(String[] args) {
		// 1.����Ŀ���ļ�
		File srcFile = new File("D:\\ѧϰ\\kou_exp\\���ݼ�\\����������\\email-Enron.txt\\email-Enron.txt");
		// 2.����һ������ָ��Ŀ���ļ�
		InputStream is = null;
		try {
			is = new FileInputStream(srcFile);
			// 3.ѭ��������
			int content = is.read();
			// 4.ѭ����ӡ
			while (content != -1) {
				System.out.print((char) content);
				content = is.read();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// �ر�io��
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
 