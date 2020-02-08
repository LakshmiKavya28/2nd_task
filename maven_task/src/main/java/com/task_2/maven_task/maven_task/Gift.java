package com.task_2.maven_task.maven_task;

import java.util.*;
import java.util.Scanner;
public class Gift {
		static Scanner input=new Scanner(System.in);
		static ArrayList<Chocolate> chs=new ArrayList<Chocolate>();
		static ArrayList<Chocolate> cds=new ArrayList<Chocolate>();
		static ArrayList<Sweet> sweets=new ArrayList<Sweet>();
		static HashMap<String,Integer> Wt=new HashMap<String,Integer>();
		static HashMap<String,Integer> Pr=new HashMap<String,Integer>();
		public static void main(String args[])
		{
			Chocolates();
			Sweets();
			System.out.println("Total weight of gift is:"+Weight_tot());
			int sort_Type=input.nextInt();
			if(sort_Type==1) {
				Comparator<Chocolate> by_Pr=new Comparator<Chocolate>() {
					@Override
					public int compare(Chocolate c1,Chocolate c2)
					{
						return((Integer)c1.getPrice()).compareTo(c2.getPrice());
					}
				};
				Collections.sort(chs,by_Pr);
			}
			else {
				Comparator<Chocolate> by_Wt=new Comparator<Chocolate>() {
					@Override
					public int compare(Chocolate c1,Chocolate c2)
					{
						return((Integer)c1.getWeight()).compareTo(c2.getWeight());}
				};
				Collections.sort(chs,by_Wt);
			}
			System.out.println("Sorted list:");
			for(Chocolate chocolate:chs) {
				System.out.println(chocolate.getPrice());
			}
			Range(sort_Type);
		}
		public static void Chocolates() {
				System.out.println("enter no. of chocolates:");
				int ch=input.nextInt();
				for(int i=1;i<=ch;i++) {
					System.out.println("enter the type(enter the number):1.candy 2.bars");
					int ch_type=input.nextInt();
					System.out.println("enter the chocolate weight:");
					int ch_weight=input.nextInt();
					System.out.println("enter the chocolate price:");
					int ch_price=input.nextInt();
					if(ch_type==1) {
						System.out.println("enter candy name:");
						String can_name=input.next();
						if(Wt.containsKey(can_name)) {
							Wt.put(can_name,(int)Wt.get(can_name)+ch_weight);
						}
						else
							Wt.put(can_name,ch_weight);
						if(Pr.containsKey(can_name)) {
							Pr.put(can_name,(int)Pr.get(can_name)+ch_price);
						}
						else
							Pr.put(can_name,ch_price);

					}
					Chocolate c=new Chocolate(ch_weight,ch_price);
					chs.add(c);
					if(ch_type==1) {
						cds.add(c);
					}
				}
		}
		public static void Sweets()
		{
			System.out.println("enter the sweets number:");
			int s=input.nextInt();
			for(int j=1;j<=s;j++) {
				System.out.println("enter the sweet weight:");
				int sWeight=input.nextInt();
				System.out.println("enter the sweet price:");
				int sPrice=input.nextInt();
				Sweet st=new Sweet(sWeight,sPrice);
				sweets.add(st);
			}
		}
		public static int Weight_tot() {
			int weight_total=0;
			for(Chocolate chocolate:chs) {
				weight_total+=chocolate.getWeight();
			}
			for(Sweet st:sweets) {
				weight_total+=st.getWeight();
			}
			return weight_total;
		}
		public static void Range(int sort_Type) {
			int ll,hl;
			if(sort_Type==1) {
				System.out.println("enter lower limit:");
				ll=input.nextInt();
				System.out.println("enter higher limit:");
				hl=input.nextInt();
				Set<Map.Entry<String,Integer>> candySet=Pr.entrySet();
				Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
				while(candyIterator.hasNext()) {
					Map.Entry<String,Integer> candyElement=(Map.Entry<String,Integer>)candyIterator.next();
					int currentPrice=(int)candyElement.getValue();
					if(currentPrice>=ll && currentPrice<=hl)
						System.out.println(candyElement.getKey());
				}
			}
			else
			{
				System.out.println("enter lower limit:");
				ll=input.nextInt();
				System.out.println("enter higher limit:");
				hl=input.nextInt();
				Set<Map.Entry<String,Integer>> candySet=Wt.entrySet();
				Iterator<Map.Entry<String,Integer>> candyIterator=candySet.iterator();
				while(candyIterator.hasNext()) {
					Map.Entry<String,Integer> candyElement=(Map.Entry<String,Integer>)candyIterator.next();
					int currentWeight=(int)candyElement.getValue();
					if(currentWeight>=ll && currentWeight<=hl)
						System.out.println(candyElement.getKey());
				}
			}
		}
}