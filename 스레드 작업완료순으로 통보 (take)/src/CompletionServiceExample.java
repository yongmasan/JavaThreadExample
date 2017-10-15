import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample extends Thread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		CompletionService<Integer> completionService = new ExecutorCompletionService<Integer>(executorService);
		
		System.out.println("작업 처리 요청");
		for(int i = 0; i < 3; i++){
			//작업을 스레드 풀에 등록
			completionService.submit(new Callable<Integer>(){
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int i = 1; i <= 10; i++)
						sum += i;
					return sum;
				}
			});
		}
		
		System.out.println("완료된 작업 확인");
		//스레드 풀에 작업 리턴 처리 쓰레드도 등록
		executorService.submit(new Runnable(){
			@Override
			public void run(){
				while(true){
					try{
						Future<Integer> future = completionService.take(); // 스레드 풀에서 완료된 작업이 있을 떄까지 블로킹
						int value = future.get();
						System.out.println("처리 결과  : " + value);
					}catch (Exception e){
						break;
					}
				}
			}
		});
		System.out.println("sleep");
		try{Thread.sleep(3000);}
		catch(InterruptedException e){}
		executorService.shutdownNow();
		System.out.println("shutdown");
	}
	
}
