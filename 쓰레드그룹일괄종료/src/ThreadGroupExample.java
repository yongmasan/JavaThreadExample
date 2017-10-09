
public class ThreadGroupExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadGroup myGroup = new ThreadGroup("MyGroup");
		WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("메인 스레드 그룹의 list() 메소드 출력 내용");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list();
		System.out.println();
		
		try{ Thread.sleep(3000);} catch(InterruptedException e){}
		
		System.out.println("MyGroup 그룹의 interrupt() 메소드 호출");
		myGroup.interrupt(); //myGroup에 소속된 쓰레드가 일괄로 종료됨

	}

}
