package minipro;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuApp {
	public static void main(String[] args) throws IOException {
		Select list = new Select();

		list.uimenu();
		list.menu();

		Scanner sc = new Scanner(System.in);

		Reader fr = new FileReader("D:\\J\\JavaStudy\\ws\\phoneDB.txt");
		BufferedReader br = new BufferedReader(fr);

		List<PhoneDB> dList = new ArrayList<PhoneDB>();
		while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			String[] data = line.split(",");
			String name = data[0];
			String hp = data[1];
			String company = data[2];

			PhoneDB db = new PhoneDB(name, hp, company);

			dList.add(db);
		}

		while (true) {
			int input = sc.nextInt();
			if (input == 5) {
				list.end();
				break;
			} else if (input < 1 || input > 5) {
				list.error();
				list.menu();
			} else {
				switch (input) {
				case 1:

					System.out.println("");
					System.out.println("<1.리스트>");
					for (int i = 0; i < dList.size(); i++) {
						System.out.print(i + 1 + ".   ");
						System.out.print(dList.get(i).getName() + "\t");
						System.out.print(dList.get(i).getHp() + "\t");
						System.out.print(dList.get(i).getCompany() + "\t");
						System.out.println("");
					}
					list.menu();
					break;

				case 2:
					System.out.println("<2.등록>");
					String k=sc.nextLine();
					System.out.print(">이름: ");
					String name = sc.nextLine();
					System.out.print(">휴대전화: ");
					String hp = sc.nextLine();
					System.out.print(">회사전화: ");
					String company = sc.nextLine();

					PhoneDB db = new PhoneDB();
					db.setName(name);
					db.setHp(hp);
					db.setCompany(company);

					dList.add(db);

					Writer fw = new FileWriter("D:\\J\\JavaStudy\\ws\\phoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);

					for (int i = 0; i < dList.size(); i++) {
						String str = dList.get(i).getName() + "," + dList.get(i).getHp() + ","
								+ dList.get(i).getCompany();
						bw.write(str);
						bw.newLine();
					}
					bw.flush();

					System.out.println("[등록되었습니다.]");
					list.menu();
					break;

				case 3:
					System.out.println("");
					System.out.println("<3.삭제>");
					int del=sc.nextInt();
					fw = new FileWriter("D:\\J\\JavaStudy\\ws\\phoneDB.txt");
					bw = new BufferedWriter(fw);
					
					for (int i = 0; i < dList.size(); i++) {
						String str = dList.get(i).getName() + "," + dList.get(i).getHp() + "," + dList.get(i).getCompany();
						bw.write(str);
						bw.newLine();
					}
					bw.flush();
					bw.close();
					System.out.println("[삭제되었습니다.]");
					dList.remove(del-1);
					
					list.menu();
					break;
				case 4:
					System.out.println("");
					System.out.println("<4.검색>");
					System.out.print(">이름: ");
					String l=sc.nextLine();
					String search = sc.nextLine();
					
					
					for (int i = 0; i < dList.size(); i++) {
						
						String serchName = dList.get(i).getName();
						if (serchName.contains(search)) {
							System.out.print(i + 1 + ".   ");
							System.out.print(dList.get(i).getName() + "\t");
							System.out.print(dList.get(i).getHp() + "\t");
							System.out.print(dList.get(i).getCompany() + "\t");
							System.out.println("");
						}
					}
				list.menu();
				break;
				}
				
			}
		br.close();
		}
		sc.close();
	}
}
