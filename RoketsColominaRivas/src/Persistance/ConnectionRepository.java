package Persistance;

public class ConnectionRepository {
	private static ConnectionBBDD connection;
	
	static ConnectionBBDD getConnection() throws Exception {
		if(connection==null)
			connection =new ConnectionBBDD("jcolomina","V47235393");
		return connection;
			
	}

}
