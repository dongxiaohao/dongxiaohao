package io_test;
//���ļ���ȡ����
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;

import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

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
	/**
	 * ���ȫ���������������ģ���node�ڵ�Ϊ���ĵ�Ŀ���ǩ�ڵ㼯�ϣ�ȱ�㣺���صļ����п��ܻẬ���ظ�Ԫ��
	 * �������������ʹ��set���Ϲ��˵��ظ�Ԫ��
	 * @param graph
	 * @param node
	 * @param target_lable
	 * @param weigth
	 * @return
	 */
	public List<Integer> floyd(GraphLink_test[] graph,int node,int target_lable,int weigth){
   			List<Integer> result=new ArrayList<>();    
   			GraphLink_test f=graph[node];
   			while(f!=null) {
   				if(f.get_weigth() <= weigth) {							 //�����ǰȨ��С����������� �������
   					if(graph_lable.getlable(f.get_adj())==target_lable)  //�����ǰ�ڵ��ǩΪĿ���ǩ �����������
   						result.add(f.get_adj());						 //��������
   					else {
   						List<Integer> mem = new ArrayList<>();			//�½�һ������ �����洢�Խڵ� ����ǰ�ڵ�Ϊ���ĵ�DF�����������Ľڵ�
   						mem=floyd(graph,f.get_adj(),target_lable,weigth-f.get_weigth());	//
   						for(int i:mem)
   							result.add(i);													//�����������Ľڵ��������result��
   					}
   					
   				}
   			}
   			
   			
   			
   			
			return result;  		//���ؽ��
   			
   			
   		}
	
}
