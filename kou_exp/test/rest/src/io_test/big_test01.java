package io_test;
//大文件读取测试
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
		
		String path = "D:\\学习\\kou_exp\\数据集\\已下载数据\\email-Enron.txt\\email-Enron.txt";
		String query_path_s="D:\\学习\\kou_exp\\查询子图\\test_1.txt";
		GraphLink_test.readMatrix(path,test_g01);
		test_g01[0].bianli(test_g01);
		query_graph small = new query_graph(5,2);
		small.init_zhitu(query_path_s);
		small.CFL();
		small.printseq();
		small.printquery_matrix();
		
		
	}
	/**
	 * 输出全部满足限制条件的，以node节点为中心的目标标签节点集合，缺点：返回的集合中可能会含有重复元素
	 * 解决方法：可以使用set集合过滤掉重复元素
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
   				if(f.get_weigth() <= weigth) {							 //如果当前权重小于输入的限制 则继续；
   					if(graph_lable.getlable(f.get_adj())==target_lable)  //如果当前节点标签为目标标签 则加入链表中
   						result.add(f.get_adj());						 //加入链表
   					else {
   						List<Integer> mem = new ArrayList<>();			//新建一个链表 用来存储以节点 但当前节点为中心的DF的满足条件的节点
   						mem=floyd(graph,f.get_adj(),target_lable,weigth-f.get_weigth());	//
   						for(int i:mem)
   							result.add(i);													//将满足条件的节点加入链表result中
   					}
   					
   				}
   			}
   			
   			
   			
   			
			return result;  		//返回结果
   			
   			
   		}
	
}
