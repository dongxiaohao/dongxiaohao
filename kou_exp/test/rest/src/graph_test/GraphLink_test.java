package graph_test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import lables.lables;

public class GraphLink_test { 
	int adjvex;
	int weight;
	GraphLink_test next;
	public GraphLink_test(){
		this.next=null;
	}
	//无权图
	public GraphLink_test(int adj,GraphLink_test nt){
		this.adjvex=adj;
		this.next=nt;
		this.weight=1;
	}
	//有权图
	public GraphLink_test(int adj,int wgt,GraphLink_test nt){
		this.adjvex=adj;
		this.weight=wgt;
		this.next=nt;
	}
   public void bianli(GraphLink_test[] a){
	   		int count=0;
	   		for(int i=0;i<a.length;i++) {
			GraphLink_test flag=a[i];
			while(flag!=null) {
			 System.out.println(i+" "+flag.adjvex+" "+flag.weight);
			 flag=flag.next;
			 count++;
		}
		}
	   		System.out.println(count);
   }
   		//读入数据
   		public static void readMatrix(String path,GraphLink_test[] test_g01) throws Exception {
		File file = new File(path);   
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));    
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);// 用5M的缓冲读取文本文件  
		  
		String line = "";
		while((line = reader.readLine()) != null){
		   //将输入分割成图中对应两个边
		   line=line.trim();
		   if(line.charAt(0)<'0'|| line.charAt(0)>'9') 
			   continue;
		   int i=0;
		   while(line.charAt(i)>='0'&&line.charAt(i)<='9') {
			   i++;
		   }
		   String s_e1=line.substring(0, i); //第一条边
		   s_e1.trim();
		   String s_e2=line.substring(i+1); //第二条边
		   s_e2.trim();
		   int e1= Integer.valueOf(s_e1).intValue(); //将第一条边转化为整数
		   int e2= Integer.valueOf(s_e2).intValue(); //将第二调表转化为整数
		   int weigth=(int)(Math.random()*3+1); //随机生成权重 范围从零到五
		   if(e1<e2) { //若e1<e2则表示还未添加，否则应已添加进邻接图中
			   test_g01[e1]=new GraphLink_test(e2,weigth,test_g01[e1]); //将第二条边加入的一条边的邻接矩阵
			   test_g01[e2]=new GraphLink_test(e1,weigth,test_g01[e2]); //将第一条边加入的二条边的邻接矩阵
		   }
		  // System.out.println(line+" "+e1+" "+e2+" "+weigth);
		   
		}
		fis.close();
		
	}
}
