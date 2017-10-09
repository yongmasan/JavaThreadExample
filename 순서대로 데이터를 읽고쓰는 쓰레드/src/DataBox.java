
public class DataBox {
	private String data = null;
	
	public synchronized String getData(){
		if(this.data == null){
			try{
				wait(); //데이터를 쓸때까지 기다린다.
			}catch(InterruptedException e){
				
			}
		}
		String returnValue = data;
		System.out.println("read Data = " + returnValue);
		data = null;
		notify();// 쓰기 쓰레드를 깨운다.
		return returnValue;
	}
	
	public synchronized void setData(String data){
		if(this.data != null){
			try{
				wait(); //데이터를 읽을때까지 기다린다.
			}catch(InterruptedException e){
				
			}
		}
		this.data = data;
		System.out.println("생성데이터= " + data);
		notify();//읽기쓰레드를 꺠운다.
	}
}
