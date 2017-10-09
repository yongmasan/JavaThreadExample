import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {
	public static void main(String[] args){
		// CPU �ھ����ŭ �����带 ���� ������Ǯ ����
		ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		System.out.println("[�۾� ó�� ��û]");
		Runnable runnable = new Runnable(){
			@Override
			public void run(){
				int sum = 0;
				for(int i = 1; i <= 10; i++){sum += i;}
				System.out.println("[ó�����] " + sum);
			}
		};
		Future future = executorService.submit(runnable);
		
		try{
			future.get(); // runnable�۾��� �Ϸ� �ɶ����� ���ŷ
			
		}catch(Exception e){
			System.out.println("[���� ���� �߻���] " + e.getMessage());
		}
		
		executorService.shutdown();
	}
}
