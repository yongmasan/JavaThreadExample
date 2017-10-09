
public class DataBox {
	private String data = null;
	
	public synchronized String getData(){
		if(this.data == null){
			try{
				wait(); //�����͸� �������� ��ٸ���.
			}catch(InterruptedException e){
				
			}
		}
		String returnValue = data;
		System.out.println("read Data = " + returnValue);
		data = null;
		notify();// ���� �����带 �����.
		return returnValue;
	}
	
	public synchronized void setData(String data){
		if(this.data != null){
			try{
				wait(); //�����͸� ���������� ��ٸ���.
			}catch(InterruptedException e){
				
			}
		}
		this.data = data;
		System.out.println("����������= " + data);
		notify();//�б⾲���带 �ƿ��.
	}
}
