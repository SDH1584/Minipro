package minipro;

public class Select {
	
	public void uimenu() {
		System.out.println("*****************************");
		System.out.println("*      전화번호 관리프로그램      *");
		System.out.println("*****************************");
	}
	
	public void menu() {

		System.out.println("");
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("------------------------------");
		System.out.print(">메뉴번호 : ");

	}

	public void end() {
		System.out.println("");
		System.out.println("******************************");
		System.out.println("*          감사합니다           *");
		System.out.println("******************************");

	}
	public void error() {
		System.out.println("");
		System.out.println(" [다시 입력해 주세요.] ");
	}
	
	public void searcherror() {
		System.out.println("검색결과가없습니다 ");
	}
}