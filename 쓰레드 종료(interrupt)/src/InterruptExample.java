
public class InterruptExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread thread = new PrintThread2(); // interruptedException 발생시켜서 종료
		Thread thread = new PrintThread3(); // interrupted 상태인지 확인해서 종료
		thread.start(); 
	
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
		}
		thread.interrupt(); // interruptedException 발생시켜 쓰레드 종료
	}

}
