import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(2);//최대쓰레드가 2인 쓰레드풀 생성
		
		for(int i = 0; i<10; i++){
			Runnable runnable = new Runnable(){
				@Override
				public void run(){
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 쓰레드 개수 : " + poolSize + "] 작업 쓰레드 이름 : " + threadName);
					//예외발생시킴
					int value = Integer.parseInt("삼");
				}
			};
			
			//////////작업 처리 execute, submit///////////////
			// [execute]
			// Runnable 작업큐에 저장, 작업처리 결과를 받지 못함
			// 예외 발생시 스레드 종료되고 스레드풀에서 제거
			executorService.execute(runnable);
			//결과 확인시 예외로 인해 새로운 쓰레드가 생성되기 때문에 스레드 이름이 다름
			
			// [submit]
			// Runnable, callable 작업 큐에 저장
			// 리턴된 Future 객체를 통해 처리 결과 확인 가능
			// 예외 발생시 쓰레드 종료되지 않고 다음 작업을 위해 재사용하여 오버헤더를 줄임,
			//executorService.submit(runnable); 
			// 결과 확인시 쓰레드를 새로 생성하지 않고 재사용하기 때문에 이름이 같음
			////////////////////////////////////////////////////////
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executorService.shutdown(); // 작업큐에 대기하고있는 모든작업을 처리한뒤에 쓰레드풀 종료
		//executorService.shudownNow(); // 현재 작업 처리 중인 스레드를 Interrupt해서 작업을 중지 시도하고 스레드풀 종료, 리턴값은 작업큐에 있는 미처리된 작업 목록
	}

}
