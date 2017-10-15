import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		System.out.println("[累诀 贸府 夸没]");
		class Task implements Runnable {
			Result result;
			Task(Result result){
				this.result = result;
			}
			
			@Override 
			public void run(){
				int sum = 0;
				for(int i = 1; i <= 10; i++){
					sum += i;
				}
				result.addValue(sum);
			}
		}
		Result  result = new Result();
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);
		
		try{
			result = future1.get();
			result = future2.get();
			System.out.println("贸府搬苞 : " + result.accumValue);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("except : " + e.getMessage());
		}
		executorService.shutdown();
	}
}

 class Result{
	int accumValue;
	public Result(){}
	synchronized void addValue(int value){
		accumValue += value;
	}
}
