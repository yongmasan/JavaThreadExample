
public class WorkObject {

	public synchronized void methodA(){
		System.out.println("methodA");
		notify(); // 다른 스레드를 깨움
		try{
			wait(); //다른 스레드가 깨울때까지 기다림
		}catch (InterruptedException e){
			
		}
	}
	
	public synchronized void methodB(){
		System.out.println("methodB");
		notify(); // 다른 스레드를 깨움
		try{
			wait(); //다른 스레드가 깨울때까지 기다림
		}catch (InterruptedException e){
			
		}
	}
}
