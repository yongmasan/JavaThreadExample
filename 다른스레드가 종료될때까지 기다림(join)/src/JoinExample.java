
public class JoinExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try{
			sumThread.join(); // sumThread�� ����ɶ� ���� ��ٸ�
		}catch(InterruptedException e){
			
		}
		
		System.out.println("�� : " + sumThread.getSum());

	}

}
