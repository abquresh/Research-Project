package GRR;


import java.util.LinkedList;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;

import GRR.Largest.point;

public class Largest {
	int[] vis;
	
	// This is subclass the object of this class is a point.
	class point{
		double x;
		double y;
	}
	
	// This function returns the distance between two points p1 and p2
	public double dis(point p1,point p2) {
		return Math.sqrt(Math.pow(p1.x-p2.x, 2)+Math.pow(p1.y-p2.y, 2));
	}
	
	
	// This function takes input as adjacency matrix representation of a graph and index of a point in array of points. And will return the maximum connected component which cotains the point at this index.
	public int siz_o_c( int[][] maya, int index) {
		int ans=0;
		for(int i=0;i<maya.length;i++) {
			if(maya[index][i]==0) {
				;
			}
			else {
				if(vis[i]==1) {
					;
				}
				else {
					vis[i]=1;
					ans=ans+1+ this.siz_o_c( maya, i);
					
				}
			}
		}
		return ans;
	}
	
	
	// This function takes input as any integer and return head with probability number/20 .
	public String prop(int number){
		Random rand = new Random();
		int value = rand.nextInt(20); 
		String ans = null;
		if(value <=number) {
		   ans = "head";
		} else { 
		   ans = "tail";
		}
		
		return ans;
	}
	public String prop1(int number){
		Random rand = new Random();
		int value = rand.nextInt(10); 
		String ans = null;
		if(value <2) {
		   ans = "head";
		} else { 
		   ans = "tail";
		}
		
		return ans;
	}
	
	
	// This function takes input as a S.D and will print the x and y coordinates of all the points generated on the rectangular grid with this value of S.D.
	public void pointsm(double sd) {
		LinkedList<point> man = new LinkedList<point>();
		
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				Random r = new Random();
				double ans1 = 0;
				double ans2 = 0;
				while(true) {
					double val = r.nextGaussian()*sd + i;
					if(val>=i-0.5 && val<=i+0.5) {
						ans1= val;
						break;
					}
				}
				while(true) {
					double val = r.nextGaussian()*sd + j;
					if(val>=j-0.5 && val<=j+0.5) {
						ans2= val;
						break;
					}
				}
				
				point lal = new point();
				
				lal.x=ans1;
				lal.y=ans2;
				man.add(lal);
				
			}
		}
		
		String x = "";
		String y = "";
		for(int k=0;k<man.size();k++) {
			System.out.println(Double.toString(man.get(k).x)+",");

		}
		for(int k=0;k<man.size();k++) {
			System.out.println(Double.toString(man.get(k).y)+",");

		}
		

		
		
		
	}
	
	// This function takes input as array of points and r and give the average degree of those graph.
	public double maxi(point[] arr, double r) {
		int[][] maya = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) {
					;
				}
				else {
					if(this.dis(arr[i], arr[j])<=r) {
						maya[i][j]=1;
					}
					else {
						;
					}
				}
			}
		}
		
		int degree = 0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(maya[i][j]==1) {
					degree++;
				}
				else {
					;
				}
			}
		}
		
		return degree/arr.length;
		
	}
	
	
	// This function takes input as array of points and r and gives the size of the largest component for the graph generated.
	public int max(point[] arr,double r) {
		int[][] maya = new int[arr.length][arr.length];
		this.vis = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) {
					;
				}
				else {
					if(this.dis(arr[i], arr[j])<=r) {
						maya[i][j]=1;
					}
					else {
						;
					}
				}
			}
		}
		
		int lar=0;
		
		for(int m=0;m<vis.length;m++) {
			if(vis[m]==0) {
				//vis[m]=1;
				int joy = 1+ this.siz_o_c(maya,m);
				if(lar<=joy) {
					lar=joy;
				}
			}
			else {
				;
			}
		}
		
		
		return lar;
		
		
		}
	
	
	
	// This function takes input as standard deviation and prints the list of fraction of infected nodes for infection rate varying from 0 to 1 at interval of 0.05. i.e 0,0.05,0.1,0.15...1.0
	public void epidemic(double sd){
		LinkedList<point> man = new LinkedList<point>();
		
		for(int i=0;i<50;i++) {
			for(int j=0;j<50;j++) {
				Random r = new Random();
				double ans1 = 0;
				double ans2 = 0;
				while(true) {
					double val = r.nextGaussian()*sd + i;
					if(val>=i-1 && val<=i+1) {
						ans1= val;
						break;
					}
				}
				while(true) {
					double val = r.nextGaussian()*sd + j;
					if(val>=j-1 && val<=j+1) {
						ans2= val;
						break;
					}
				}
				
				point lal = new point();
				lal.x=ans1;
				lal.y=ans2;
				man.add(lal);
				
			}
		}
		
		point[] arr = new point[man.size()];
		for(int m=0;m<arr.length;m++) {
			arr[m]=man.get(m);
		}
		
		int[][] maya = new int[arr.length][arr.length];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) {
					;
				}
				else {
					if(this.dis(arr[i], arr[j])<=1.3) {
						maya[i][j]=1;
					}
					else {
						;
					}
				}
			}
		}
		
		System.out.println("abdul");
		LinkedList<Double> fraction = new LinkedList<Double>();
		for(int y=0;y<=20;y++) {
			int[] status = new int[arr.length];
			for(int m=0;m<25;m++) {
			Random rand = new Random();
			int value = rand.nextInt(status.length-1);
			
			status[value] = 1;
			}
		
		int tick = 0;
		int infection =5;
		
		LinkedList<Integer> ansi = new LinkedList<Integer>();

		
		int ite = 0;
		while(ite<2000) {
		//System.out.println("abdul");
		for(int i=0;i<status.length;i++) {
			if(status[i]==1) {
				for(int p=0;p<maya.length;p++) {
					if(maya[i][p]==1) {
						String jay = this.prop(y);
						if(jay=="head") {
							status[p]=1;
						}
						else {
							;
						}
					}
				}
			}
			else {
				;
			}
			
			String jaya = this.prop1(10);
			if(jaya=="head") {
				status[i]=0;
			}
			else {
				;
			}
			//status[i]=0;
		}
		if(ite>5) {
		int an = 0;
		for(int m=0;m<status.length;m++) {
			if(status[m]==1) {
				an++;
			}
			else {
				;
			}
		}
		
		ansi.add(an);
		
		
		}

		ite++;
		}
		
		
		int sum=0;
		for(int k=0;k<ansi.size();k++) {
			sum=sum+ansi.get(k);
		}
		double ave = sum/ansi.size();
		fraction.add(ave/2500);
		

		}
		for(int u=0;u<fraction.size();u++) {
			System.out.println(fraction.get(u));
		}
	}
	
	// Now in this static function you can use any of the function above
	public static void main(String[] args) throws IOException{
//	Largest lol = new Largest();
//
//	
//	
//	double[][] mob = new double[21][31];
//	
//
//	Object[] lat = new Object[21];
//	float ay = (float) 1.00;
//	for(int m=0;m<lat.length;m++) {
//		lat[m]=Math.round(ay * 100.0) / 100.0;
//		ay=(float) (ay-0.05);
//	}
//	Object[] mat = new Object[31];
//	float by = (float) 0.90;
//	for(int m=0;m<mat.length;m++) {
//		mat[m]=Math.round(by * 100.0) / 100.0;
//		by=(float) (by+0.01);
//	}
//	
//	int ma=0;
//	for(double sd = 20.00; sd>=20.00;sd=sd-0.05) {
//		int ja=0;
//		for(double ra=0.9;ra<1.2;ra=ra+0.01) {
//			//System.out.println("abdul");
//			LinkedList<Integer> meanm = new LinkedList<Integer>();
//			for(int k=0;k<100;k++) {
//			LinkedList<point> man = new LinkedList<point>();
//			
//			for(int i=0;i<50;i++) {
//				for(int j=0;j<50;j++) {
//					Random r = new Random();
//					double ans1 = 0;
//					double ans2 = 0;
//					ans1 = r.nextGaussian()*sd + i;
//					ans2 = r.nextGaussian()*sd + j;
					
//					while(true) {
//						double val = r.nextGaussian()*sd + i;
//						if(val>=i-0.5 && val<=i+0.5) {
//							ans1= val;
//							break;
//						}
//					}
//					while(true) {
//						double val = r.nextGaussian()*sd + j;
//						if(val>=j-0.5 && val<=j+0.5) {
//							ans2= val;
//							break;
//						}
//					}
					
//					Largest.point lal = lol.new point();
//					lal.x=ans1%49;
//					lal.y=ans2%49;
//					man.add(lal);
//					
//				}
//			}
//			
//			point[] arr = new point[man.size()];
//			for(int m=0;m<arr.length;m++) {
//				arr[m]=man.get(m);
//			}
//			
//			meanm.add(lol.max(arr, ra));
//			
//			}
//			
//			double fi = 0;
//			
//			for(int t=0;t<meanm.size();t++) {
//				fi=fi+meanm.get(t);
//			}
//			
//			System.out.println(Double.toString(fi/(meanm.size()))+",");
//			mob[ma][ja]= fi/(meanm.size());
//			
//			ja++;
//		}
//		ma++;
//	}
	
//	HeatChart map = new HeatChart(mob);
//
//	
//	map.setTitle(" SD vs r vs Largest Component heatchart");
//	map.setXAxisLabel("r-->");
//	map.setYAxisLabel("Standard Deviation");
//	map.setYValues(lat);
//	map.setXValues(mat);
//	
//	map.saveToFile(new File("java-heat-chart.png"));
	
		Largest tes = new Largest();
		tes.epidemic(3.5);
//		double random = ThreadLocalRandom.current().nextDouble(0, 50);
//		System.out.println(random);
		
//		for(double ra=0.9;ra<1.2;ra=ra+0.01) {
//			LinkedList<Integer> meanma = new LinkedList<Integer>();
//			for(int k=0;k<100;k++) {
//			LinkedList<point> rat = new LinkedList<point>();
//			for(int i=0;i<2500;i++) {
//				Largest.point man = lol.new point();
//				man.x = ThreadLocalRandom.current().nextDouble(0, 50);
//				man.y = ThreadLocalRandom.current().nextDouble(0, 50);
//				rat.add(man);
//			}
//			point[] arrr = new point[rat.size()];
//			for(int m=0;m<arrr.length;m++) {
//				arrr[m]=rat.get(m);
//			}
//			meanma.add(lol.max(arrr, ra));
//			}
//			
//			int fii = 0;
//			
//			for(int t=0;t<meanma.size();t++) {
//				fii=fii+meanma.get(t);
//			}
//			
//			System.out.println(fii/(meanma.size()));
//			
//		}
		
		

	}
	
}
