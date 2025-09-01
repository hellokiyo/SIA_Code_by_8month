package addrbook;

public class AddrBookDeleteMain {
	public static void main(String[] args) throws Exception {
		System.out.println("addrbook id list");
		boolean result = new AddrBookDAO().deleteDB(7);
		
		System.out.println(result);
		
	}
}
