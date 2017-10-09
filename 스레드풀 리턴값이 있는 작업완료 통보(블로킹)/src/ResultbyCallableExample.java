import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultbyCallableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// CPU 코어수만큼 스레드를 가진 스레드풀 생성
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[작업처리요청]");
		
		Callable<Integer> task = new Callable<Integer>(){
			@Override
			public Integer call() throws Exception{
				int sum = 0;
				for(int i = 1; i<=10; i ++){
					sum += i;
				}
				return sum;
			}
		};
		
		Future<Integer> future = executorService.submit(task);
		
		try {
			int sum = future.get(); // task쓰레드가 작업이 완료 될때까지 블로킹
			System.out.println("[처리결과] " + sum);
			System.out.println("[작업완료]");
		}catch(Exception e){
			System.out.println("[실행예외 발생함] " + e.getMessage());
		}
		executorService.shutdown();
	}

}
