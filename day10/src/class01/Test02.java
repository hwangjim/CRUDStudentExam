package class01;

import java.util.Scanner;

class Student {
	String name;
	int score;

	void showInfo() {
		System.out.println(this.name + "학생은 " + this.score + "점입니다.");
	}

	Student(String name, int score) {
		this.name = name;
		this.score = score;
		System.out.println(this.name + "학생 입력완료!");
	}
}

public class Test02 {
	public static void main(String[] args) {
		// 학생부 프로그램
		// 학생 정보를 배열에 저장해서 관리하는 프로그램
		// 핵심 로직
		// 비즈니스 메소드
		// CRUD

		Student[] data = new Student[3];
		// 최대 크기 : data.length
		int index = 0; // 현재 저장된 학생 수

		Scanner sc = new Scanner(System.in);
		while (true) {

			// CRUD
			// 비즈니스 메서드
			// 핵심 로직
			System.out.println("1. 추가");
			System.out.println("2. 출력");
			System.out.println("3. 변경");
			System.out.println("4. 삭제");
			System.out.println("5. 종료");
			System.out.print("입력) ");
			int act = sc.nextInt();
			// 사용자가 입력하면 -> 유효성 검사!
			
			// 1번 선택시
			if (act == 1) {
				// 현재 저장된 학생수와 등록 가능한 학생의 최대 수인 3이 같다면
				if (index == data.length) {
					System.out.println("데이터공간이 부족!");
					continue;
				}
				
				System.out.print("학생이름 입력: ");
				String name = sc.next();
				System.out.print("학생성적 입력: ");
				int score = sc.nextInt();
				// 입력한 이름과 성적을 data배열에 저장 
				data[index] = new Student(name, score);
				// 입력 후엔 data[] 내 인덱스 넘버가 늘어나게끔
				index++;

			} else if (act == 2) {
				if (index == 0) {
					System.out.println("저장한 정보가 없습니다!");
					continue;
				}
				System.out.println("===학생목록===");
				for (int i = 0; i < index; i++) {
					data[i].showInfo();
				}
			} else if (act == 3) {
				if (index == 0) {
					System.out.println("저장한 정보가 없습니다!");
					continue;
				}
				System.out.print("정보를 변경할 학생의 번호입력: ");
				int num = sc.nextInt(); 		// num == 인덱스 넘버를 의미 
				num--; // 번호와 인덱스넘버의 차이
				if (num < 0 || index <= num) { // 유효성 검사
					System.out.println("없는 번호입니다! 확인후 다시이용해주세요~~");
					continue;
				}
				System.out.print("변경할 점수입력: ");
				data[num].score = sc.nextInt();
				System.out.println(data[num].name + "학생 정보 변경완료!");
			} else if (act == 4) {
				if(index == 0) {
					System.out.println("삭제할 데이터가 없습니다.");
					continue;
				}
				System.out.println("최근 데이터 삭제");
				index--;
				System.out.println("삭제 완료 !");
			} else if (act == 5) {
				System.out.println("종료합니다..");
				// 종료조건
			} else {
				System.out.println("잘못된 입력입니다. ");
			}
		}

	}
}
