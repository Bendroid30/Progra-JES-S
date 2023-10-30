
class HiloSumador2 implements Runnable{
	
	int n1,n2;
	
	public HiloSumador2(int n1,int n2) {
		this.n1=n1;
		this.n2=n2;
	}

	@Override
	public void run() {
		long suma=0;
		for (int i=n1;i<=n2;i++) {
			suma+=i;
		}
		System.out.println(n1+" al "+n2+":"+suma);
	}	
}

public class SumadorConHilos2 {

	public static void main(String[] args) {
		Thread t1=new Thread(new HiloSumador2(1,10));
		Thread t2=new Thread(new HiloSumador2(11,20));
		Thread t3=new Thread(new HiloSumador2(21,30));
		Thread t4=new Thread(new HiloSumador2(31,40));
		Thread t5=new Thread(new HiloSumador2(41,50));
		Thread t6=new Thread(new HiloSumador2(51,60));
		Thread t7=new Thread(new HiloSumador2(61,70));
		Thread t8=new Thread(new HiloSumador2(71,80));
		Thread t9=new Thread(new HiloSumador2(81,90));
		Thread t10=new Thread(new HiloSumador2(91,100));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		
	}
}