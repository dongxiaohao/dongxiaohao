package rest;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.util.*;

public class test {
	
	 public static void main(String[] args) throws Exception {
		   int[][] t=new int[5][5];
		   List<Integer> seq=new ArrayList<>();
		   String path="D:\\ѧϰ\\kou_exp\\��ѯ��ͼ\\test_1.txt";
	       init_zhitu(t,path);
	       for(int i=0;i<t.length;i++) {
	    	   for(int j=0;j<t.length;j++)
	    		   System.out.print(t[i][j]+" ");
	    	   System.out.println();
	       }
	       
	       CFL(t,seq);
	       for(int i:seq)
	       System.out.print(i+" ");

	    }
	 
	 //��ʼ����ѯ��ͼ
	 
	  public static void init_zhitu(int[][] t,String path) throws Exception {
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
				  t[row][colume]=Integer.valueOf(mem.trim()).intValue();	//��������
				  colume++;		// �ƶ���Ӧ��
				  l_flag+=2;	//�ƶ�����һ������
				  r_flag+=2;	//�ƶ�����һ���ո�
				  
			  }
			  row++;			//��������
				
		  }
		  fis.close();
		  
	  }
	  
	  
	  //CFL �ֽ�
	  public static void CFL(int[][] mat, List<Integer> sep) {
		  LinkedHashSet<Integer> s=new LinkedHashSet<>();
		  List<Integer> l=new ArrayList<>();
		  int[][] n_m=new int[mat.length][mat.length];
		  int flag=0;
		  for(int i=0;i<mat.length;i++)
	        	for(int j=0;j<mat.length;j++)
	        		n_m[i][j]=mat[i][j];
		  //ɸѡ��Ҷ�Ӻ�ɭ�ֽڵ� ����������l
		  while(flag==0)
		  {
			  flag=1;
			  for(int i=0;i<mat.length;i++) {
				  int count=0;
				  for(int j=0;j<mat.length;j++) {
					  if(n_m[i][j]!=0) count++;
				  }
				  if(count==1) {
					  flag=0;
					  l.add(i);
				  }
			  }
			  for(int i:l)
			  for(int m=0;m<mat.length;m++) {
				  n_m[i][m]=0;
				  n_m[m][i]=0;
			  }
		  }
		  //����һ�����Ľڵ���뼯�� ���Ӷ���С�����ͽڵ�
		  s.add(4);
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
		       sep.add(a);
		  for(int i=l.size()-1;i>=0;i--) {
			  sep.add(l.get(i));
		  }
		    
	  }
	  

}