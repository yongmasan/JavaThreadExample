import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
	private ExecutorService executorService;
	
	public CallbackExample(){
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	//<r, a> r: ���ϰ�, a: ÷�� Ÿ��
	private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>(){
		@Override
		//������ �ݹ� �Ķ���� (���, ÷�ΰ�)
		public void completed(Integer result, Void attachment){
			System.out.println("completed " + result);
		}
		
		@Override
		//���н� �ݹ�
		//�Ķ���� : ���� Ÿ��, ÷��Ÿ��
		public void failed(Throwable exc, Void attachment){
			System.out.println("Failed : " + exc.toString());
		}
	};
	
	public void doWork(final String x, final String y){
		Runnable task = new Runnable(){
			@Override
			public void run(){
				try{
					int intX = Integer.parseInt(x);
					int intY = Integer.parseInt(y);
					int result = intX + intY;
					//������ Completed ȣ��
					callback.completed(result,  null);
				}catch(NumberFormatException e){
					//���н� failed ȣ��
					callback.failed(e, null);
				}
			}
		};
		//������Ǯ�� �۾� ���
		executorService.submit(task);
	}
	
	public void finish(){
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallbackExample example = new CallbackExample();
		example.doWork("3", "3");
		example.doWork("3", "��");// ���� �߻���Ŵ
		example.finish();
	}

}
