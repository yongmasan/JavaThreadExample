
public class WorkObject {

	public synchronized void methodA(){
		System.out.println("methodA");
		notify(); // �ٸ� �����带 ����
		try{
			wait(); //�ٸ� �����尡 ���ﶧ���� ��ٸ�
		}catch (InterruptedException e){
			
		}
	}
	
	public synchronized void methodB(){
		System.out.println("methodB");
		notify(); // �ٸ� �����带 ����
		try{
			wait(); //�ٸ� �����尡 ���ﶧ���� ��ٸ�
		}catch (InterruptedException e){
			
		}
	}
}
