package lables;

import java.util.List;

public class lables {
	private int[] lable;								// 将标签存入对应的节点标签对应位
	private int[] lable_count;							//统计每类标签的数量
	//List<Integer> lable_classification;		
	public lables(int length,int count) {
		this.lable=new int[length];
		this.lable_count=new int[count];
		for(int i=0;i<length;i++) {
			int mem=(int)(Math.random()*count); 	//随机生一个标签
			this.lable[i]=mem;						//将标签存入对应节点
			this.lable_count[mem]++;				//对应标签的数量增加一个
			
		}
		
	}
	public int getlable(int flag){
		return this.lable[flag];
		
	}
	public int getCount(int flag) {
		return this.lable_count[flag];
	}

}
