import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//회원가입 중복확인

public class Library_main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Main_methods dao = new Main_methods();
		while (true) {
			System.out.println("1. 학생 로그인\n2. 사서 로그인\n3. 회원가입\n4. 종료\n메뉴를 입력하세요 : ");
			int x = System.in.read() - 48;
			System.in.read();
			System.in.read();
			if (x == 1) {
				System.out.println("로그인 페이지 입니다. -1 입력 시 메뉴로 돌아갑니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				if(!id.equals("-1")){
					System.out.print("Password : ");
					String pass = in.readLine();
					if(!pass.equals("-1")){
						boolean bool = dao.loginMember(id, pass);
						if (bool)
							System.out.println("로그인에 성공하였습니다~!");
						else
							System.out.println("로그인에 실패하였습니다");
						System.out.println("");
					}
				}
			} else if (x == 2) {
				System.out.println("로그인 페이지 입니다. -1 입력 시 메뉴로 돌아갑니다.");
				System.out.print("ID : ");
				String id = in.readLine();
				if(!id.equals("-1")){
					System.out.print("Password : ");
					String pass = in.readLine();
					if(!id.equals("-1")){
						boolean bool = dao.loginMember(id, pass);
						if (bool)
							System.out.println("로그인에 성공하였습니다~!");
						else
							System.out.println("로그인에 실패하였습니다");
						System.out.println("");
					}
				}
			} else if (x == 3) {
				System.out.println("회원가입 페이지 입니다. -1 입력 시 메뉴로 돌아갑니다.");
				System.out.print("ID: ");
				String id = in.readLine();
				if(!id.equals("-1")){
					String confirm = "No";
					do{
						System.out.print("Password : ");
						String pass = in.readLine();
						if(!pass.equals("-1")){ 
							System.out.print("Password Confirm : ");
							String passconfirm = in.readLine();
							if(pass.equals(passconfirm))
								confirm = "Yes";
							else
								System.out.println("* 비밀번호가 일치하지 않습니다.");
							if(!passconfirm.equals("-1")&&confirm.equals("Yes")){
								System.out.println("* 비밀번호 일치");
								System.out.print("name : ");
								String name = in.readLine();
								if(!name.equals("-1")){ 
									System.out.print("department : ");
									String department = in.readLine();
									if(!department.equals("-1")){ 
										boolean bool = dao.registerMember(id, pass, name, department);
										if (bool)
											System.out.println("회원가입에 성공하였습니다~!");
										else
											System.out.println("회원가입에 실패하였습니다!!");
										System.out.println("");
									}
								}
							}
						}
					}while(confirm.equals("No"));
				}
			} else if (x == 4) {
				System.exit(0);
			} else {
				System.err.println("잘못 입력!!");
			}
		}
	}
}
