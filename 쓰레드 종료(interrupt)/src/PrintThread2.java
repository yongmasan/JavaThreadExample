
public class PrintThread2 extends Thread {
	public void run(){
		try{
			while(true){
				System.out.println("실행중");
				Thread.sleep(1); // 종료하기 위한 InterruptedException을 발생시키기위해 호출
			}
		}catch(InterruptedException e){
			
		}
		System.out.println("자원정리");
		System.out.println("실행종료");
	}
}
