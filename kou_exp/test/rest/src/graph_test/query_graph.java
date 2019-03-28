package graph_test;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.*;
import io_test.*;

import lables.lables;
public class query_graph {
		public int[][] query_matrix;
		public List<Integer> seq;
		public lables query_lable;
		
//	 public static void main(String[] args) throws Exception {
//		   int[][] t=new int[5][5];
//		   List<Integer> seq=new ArrayList<>();
//		   String path="D:\\ѧϰ\\kou_exp\\��ѯ��ͼ\\test_1.txt";
//	       init_zhitu(t,path);
//	       for(int i=0;i<t.length;i++) {
//	    	   for(int j=0;j<t.length;j++)
//	    		   System.out.print(t[i][j]+" ");
//	    	   System.out.println();
//	       }
//	       
//	       CFL(t,seq);
//	       for(int i:seq)
//	       System.out.print(i+" ");
//
//	    }
	 public query_graph(int scale,int count) {
		 this.query_matrix=new int[scale][scale];
		 this.seq=new ArrayList<>();
		 this.query_lable=new lables(scale,count);
	 }
	 
	 //��ʼ����ѯ��ͼ
	public void init_zhitu(String path) throws Exception {
		  File file = new File(path);   
		  BufferedInputStream fis = new BufferedInputStream(new FileInputStream(file));    
		  BufferedReader reader = new BufferedReader(new InputStreamReader(fis,"utf-8"),5*1024*1024);// ��5M�Ļ����ȡ�ı��ļ�  
		  String line = "";
		  int row=0,colume=0;
		  while((line = reader.readLine()) != null) {
			  colume=0;
			  //���ó�ʼֵ
			  int l_flag=0,r_flag=1;
			  line=line.trim();
			  int len=line.length();
			  while(r_flag<=len){
				  String mem;;
				  //�������ȡ����
				  if(r_flag<len-1)
					  mem=line.substring(l_flag, r_flag); 
				  else 
					  mem=line.substring(l_flag); 
				  this.query_matrix[row][colume]=Integer.valueOf(mem.trim()).intValue();	//��������
				  colume++;		// �ƶ���Ӧ��
				  l_flag+=2;	//�ƶ�����һ������
				  r_flag+=2;	//�ƶ�����һ���ո�
				  
			  }
			  row++;			//��������
				
		  }
		  fis.close();
		  
	  }
	  
	  
	  //CFL �ֽ�
	  public void CFL(){
		  LinkedHashSet<Integer> s=new LinkedHashSet<>();
		  List<Integer> l=new ArrayList<>();
		  int scale=this.query_matrix.length;
		  int[][] n_m=new int[scale][scale];
		  int flag=0;
		  for(int i=0;i<scale;i++)
	        	for(int j=0;j<scale;j++)
	        		n_m[i][j]=this.query_matrix[i][j];
		  //ɸѡ��Ҷ�Ӻ�ɭ�ֽڵ� ����������l
		  while(flag==0)
		  {
			  flag=1;
			  for(int i=0;i<scale;i++) {
				  int count=0;
				  for(int j=0;j<scale;j++) {
					  if(n_m[i][j]!=0) count++;
				  }
				  if(count==1) {
					  flag=0;
					  l.add(i);
				  }
			  }
			  for(int i:l)
			  for(int m=0;m<scale;m++) {
				  n_m[i][m]=0;
				  n_m[m][i]=0;
			  }
		  }
		  //����һ�����Ľڵ���뼯�� ���Ӷ���С�����ͽڵ�
		  int min_node=0,min_degree=Integer.MAX_VALUE;
		  for(int i=0;i<scale;i++) {
			  for(int j=0;j<scale;j++) {
				  if(n_m[i][j]!=0) {												//Ѱ�ҵ��Ȳ�Ϊ��Ľڵ�
					  int pre_lable=this.query_lable.getlable(i);					//�õ���ǰ�ڵ�ı�ǩ
					  if(big_test01.graph_lable.lable_count[pre_lable]<min_degree) {		//�жϴ�ͼ�ж�Ӧ���͵Ľڵ��Ƿ�Ϊ��ǰ��С
						  min_degree=big_test01.graph_lable.lable_count[pre_lable];
						  min_node=i;
					  }
					  break;						//������ǰѭ��
				  }
			  }
		  }
		  s.add(min_node); 			//����Сƥ��ڵ���뼯�� S
		  //����������ȱ���,Ϊ��ֹ��ͬ�ڵ���� ��ʹ��set
		  for(int a=0;a<s.size();a++) {
			  String str=s.toString();			//������ת��Ϊ�ַ���
			  int mem=str.charAt(a*3+1)-'0';	//ѡ�ҵ���Ӧλ�Ľڵ���
			  //System.out.println(str+"   "+str.charAt(a*3+1)+"  "+mem);
			  for(int i=0;i<n_m.length;i++) 	//�Ե�ǰ�ڵ��Ž��б���
				  if(n_m[i][mem]!=0) {
			   //  System.out.print(n_m[i][mem]+" ");
					  s.add(i);	//
				  	  
			  }
		  }
		  //����Ҷ�Ӻ�ɭ�ֽڵ�
		  for(int a:s)
		       this.seq.add(a);
		  for(int i=l.size()-1;i>=0;i--) {
			  this.seq.add(l.get(i));
		  }
		    
	  }
	  public void printseq() {
		  for(int i:this.seq)
			  System.out.print(i+" ");
		  System.out.println();
	  }
	  public void printquery_matrix() {
		 for(int i=0;i<this.query_matrix.length;i++) {
			 for(int j=0;j<this.query_matrix.length;j++)
				 System.out.print(this.query_matrix[i][j]+" ");
			 System.out.println();
		 }
	  }

}