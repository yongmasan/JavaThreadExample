import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {
	public static void main(String[] args){
		// CPU 코어수만큼 스레드를 가진 스레드풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[작업 처리 요청]");
		Runnable runnable = new Runnable(){
			@Override
			public void run(){
				int sum = 0;
				for(int i = 1; i <= 10; i++){sum += i;}
				System.out.println("[처리결과] " + sum);
			}
		};
		Future future = executorService.submit(runnable);
		
		try{
			future.get(); // runnable작업이 완료 될때까지 블로킹
			
		}catch(Exception e){
			System.out.println("[실행 예외 발생함] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
