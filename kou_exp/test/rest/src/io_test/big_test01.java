package io_test;
//���ļ���ȡ����
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;

import graph_test.GraphLink_test;
import graph_test.query_graph;
import lables.lables;


public class big_test01 {
	public static lables graph_lable=new lables(36692,20);
	
	public static void main(String args[]) throws Exception {
		GraphLink_test[] test_g01=new GraphLink_test[36692];
		
		String path = "D:\\ѧϰ\\kou_exp\\���ݼ�\\����������\\email-Enron.txt\\email-Enron.txt";
		String query_path_s="D:\\ѧϰ\\kou_exp\\��ѯ��ͼ\\test_1.txt";
		GraphLink_test.readMatrix(path,test_g01);
		test_g01[0].bianli(test_g01);
		query_graph small = new query_graph(5,2);
		small.init_zhitu(query_path_s);
		small.CFL();
		small.printseq();
		small.printquery_matrix();
		
		
	}
	
}