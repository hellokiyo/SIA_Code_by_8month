package addrbook;

public class AddrBookUpdatingMain {
	public static void main(String[] args) throws Exception {
		System.out.println("addrbook id list");
		AddrBookVO vo = new AddrBookVO();
		vo.abId = 1;
		vo.abName = "haha";
		vo.abEmail = "hahajava@naver.com";
		vo.abTel = "010-1111-1111";
		boolean result = new AddrBookDAO().updateDB(vo);
		System.out.println(result);
		
	}
}
