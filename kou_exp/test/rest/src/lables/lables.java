package lables;

import java.util.List;

public class lables {
	private int[] lable;								// ����ǩ�����Ӧ�Ľڵ��ǩ��Ӧλ
	private int[] lable_count;							//ͳ��ÿ���ǩ������
	//List<Integer> lable_classification;		
	public lables(int length,int count) {
		this.lable=new int[length];
		this.lable_count=new int[count];
		for(int i=0;i<length;i++) {
			int mem=(int)(Math.random()*count); 	//�����һ����ǩ
			this.lable[i]=mem;						//����ǩ�����Ӧ�ڵ�
			this.lable_count[mem]++;				//��Ӧ��ǩ����������һ��
			
		}
		
	}
	public int getlable(int flag){
		return this.lable[flag];
		
	}
	public int getCount(int flag) {
		return this.lable_count[flag];
	}

}
