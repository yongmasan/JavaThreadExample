
public class JoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try{
			sumThread.join(); // sumThread가 종료될때 까지 기다림
		}catch(InterruptedException e){
			
		}
		
		System.out.println("합 : " + sumThread.getSum());

	}

}
