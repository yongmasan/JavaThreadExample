
public class PrintThread3 extends Thread {
	public void run(){
		while(true){
			System.out.println("���� ��");
			if(Thread.interrupted())// interrupted �������� Ȯ���Ѵ�.
			//if(this.isInterrupted())
				break;
		}
		System.out.println("�ڿ�����");
		System.out.println("��������");
	}
}
