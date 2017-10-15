import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackExample {
	private ExecutorService executorService;
	
	public CallbackExample(){
		executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	}
	//<r, a> r: 리턴값, a: 첨부 타입
	private CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>(){
		@Override
		//성공시 콜백 파라미터 (결과, 첨부값)
		public void completed(Integer result, Void attachment){
			System.out.println("completed " + result);
		}
		
		@Override
		//실패시 콜백
		//파라미터 : 예외 타입, 첨부타입
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
					//성공시 Completed 호출
					callback.completed(result,  null);
				}catch(NumberFormatException e){
					//실패시 failed 호출
					callback.failed(e, null);
				}
			}
		};
		//스레드풀에 작업 등록
		executorService.submit(task);
	}
	
	public void finish(){
		executorService.shutdown();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallbackExample example = new CallbackExample();
		example.doWork("3", "3");
		example.doWork("3", "삼");// 예외 발생시킴
		example.finish();
	}

}
