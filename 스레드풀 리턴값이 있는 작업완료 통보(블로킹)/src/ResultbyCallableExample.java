import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultbyCallableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// CPU �ھ����ŭ �����带 ���� ������Ǯ ����
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[�۾�ó����û]");
		
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
			int sum = future.get(); // task�����尡 �۾��� �Ϸ� �ɶ����� ���ŷ
			System.out.println("[ó�����] " + sum);
			System.out.println("[�۾��Ϸ�]");
		}catch(Exception e){
			System.out.println("[���࿹�� �߻���] " + e.getMessage());
		}
		executorService.shutdown();
	}

}
