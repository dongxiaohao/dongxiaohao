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
	//��Ȩͼ
	public GraphLink_test(int adj,GraphLink_test nt){
		this.adjvex=adj;
		this.next=nt;
		this.weight=1;
	}
	//��Ȩͼ
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
   		//��������
   		public static void readMatrix(String path,GraphLink_test[] test_g01) throws Exception {
		File file = new File(path);   
		BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));    
		BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);// ��5M�Ļ����ȡ�ı��ļ�  
		  
		String line = "";
		while((line = reader.readLine()) != null){
		   //������ָ��ͼ�ж�Ӧ������
		   line=line.trim();
		   if(line.charAt(0)<'0'|| line.charAt(0)>'9') 
			   continue;
		   int i=0;
		   while(line.charAt(i)>='0'&&line.charAt(i)<='9') {
			   i++;
		   }
		   String s_e1=line.substring(0, i); //��һ����
		   s_e1.trim();
		   String s_e2=line.substring(i+1); //�ڶ�����
		   s_e2.trim();
		   int e1= Integer.valueOf(s_e1).intValue(); //����һ����ת��Ϊ����
		   int e2= Integer.valueOf(s_e2).intValue(); //���ڶ�����ת��Ϊ����
		   int weigth=(int)(Math.random()*3+1); //�������Ȩ�� ��Χ���㵽��
		   if(e1<e2) { //��e1<e2���ʾ��δ���ӣ�����Ӧ�����ӽ��ڽ�ͼ��
			   test_g01[e1]=new GraphLink_test(e2,weigth,test_g01[e1]); //���ڶ����߼����һ���ߵ��ڽӾ���
			   test_g01[e2]=new GraphLink_test(e1,weigth,test_g01[e2]); //����һ���߼���Ķ����ߵ��ڽӾ���
		   }
		  // System.out.println(line+" "+e1+" "+e2+" "+weigth);
		   
		}
		fis.close();
		
	}
}