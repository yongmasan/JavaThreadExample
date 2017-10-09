import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executorService = Executors.newFixedThreadPool(2);//�ִ뾲���尡 2�� ������Ǯ ����
		
		for(int i = 0; i<10; i++){
			Runnable runnable = new Runnable(){
				@Override
				public void run(){
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolSize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[�� ������ ���� : " + poolSize + "] �۾� ������ �̸� : " + threadName);
					//���ܹ߻���Ŵ
					int value = Integer.parseInt("��");
				}
			};
			
			//////////�۾� ó�� execute, submit///////////////
			// [execute]
			// Runnable �۾�ť�� ����, �۾�ó�� ����� ���� ����
			// ���� �߻��� ������ ����ǰ� ������Ǯ���� ����
			executorService.execute(runnable);
			//��� Ȯ�ν� ���ܷ� ���� ���ο� �����尡 �����Ǳ� ������ ������ �̸��� �ٸ�
			
			// [submit]
			// Runnable, callable �۾� ť�� ����
			// ���ϵ� Future ��ü�� ���� ó�� ��� Ȯ�� ����
			// ���� �߻��� ������ ������� �ʰ� ���� �۾��� ���� �����Ͽ� ��������� ����,
			//executorService.submit(runnable); 
			// ��� Ȯ�ν� �����带 ���� �������� �ʰ� �����ϱ� ������ �̸��� ����
			////////////////////////////////////////////////////////
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		executorService.shutdown(); // �۾�ť�� ����ϰ��ִ� ����۾��� ó���ѵڿ� ������Ǯ ����
		//executorService.shudownNow(); // ���� �۾� ó�� ���� �����带 Interrupt�ؼ� �۾��� ���� �õ��ϰ� ������Ǯ ����, ���ϰ��� �۾�ť�� �ִ� ��ó���� �۾� ���
	}

}
