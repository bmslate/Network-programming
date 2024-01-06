import java.io.EOFException;
import java.io.IOException;

public class Client1test {

	    public static void main(String[] args) throws EOFException {
	        
	    	try {
	    	Client1 client = new Client1("localhost", 1254); // 使用服务器的 IP 地址和端口号
	        
	        client.runClient1();
	        
	    	}catch(IOException e) {
	    		
	    		e.printStackTrace();
	    	}
	    }
	

}
