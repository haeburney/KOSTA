package prj2_2;

import java.util.Scanner;

public class Picachu {	// 피카추 키우기 게임
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int num;
		// 1.밥 먹기 2.잠자기 3.운동하기 4.놀기 5.종료
		// 나는 while문을 true로 해놓고 풀었는데
		// boolean 변수를 하나 선언해서 할 수도 있다.

		boolean flag = true;
		int hp = 30, exp = 0, lv = 1;
		// hp 0되면 죽는다. exp 놀거나 운동하면 경험치 상승. exp 20마다 레벨 상승

		while (flag) {
			System.out.println("********** 번호를 고르시오. **********");
			System.out.println("1.밥 먹기 2.잠자기 3.운동하기 4.놀기 5.종료 6.상태확인");
			num = sc.nextInt();

			// hp = 0 이하 캐릭터 사망 게임 종료

			switch (num) {
			case 1:
				System.out.println("피카츄가 밥을 먹고 있어요!.");
				hp += 5;
				break;
			case 2:
				System.out.println("피카츄가 잠을 자고 있어요!.");
				hp += 10;
				break;
			case 3:
				System.out.println("피카츄가 운동하고 있어요!.");
				hp -= 8;
				if (hp <= 0) {
					System.out.println("피카츄가 사망하였습니다...");
					System.out.println("게임 종료...");
					flag = false; // while문을 종료
					break; // switch 종료를 뜻함
				}
				exp += 7;
				if (exp >= 20) {
					exp -= 20;
					lv++;
					System.out.println("축하해요. 피카추의 레벨이 "+lv+"레벨이 되었어요!");
					break;
				}
				break;
			case 4:
				System.out.println("피카츄가 놀고 있어요!.");
				hp -= 5;
				if (hp <= 0) {
					System.out.println("피카츄가 사망하였습니다...");
					System.out.println("게임 종료...");
					flag = false; // while문을 종료
					break; // switch 종료를 뜻함
				}
				exp += 3;
				if (exp >= 20) {
					exp -= 20;
					lv++;
					System.out.println("축하해요. 피카추의 레벨이 "+lv+"레벨이 되었어요!");
					break;
				}
				break;
			case 5:
				flag = false;
				System.out.println("게임이 종료되었습니다..");
				break;
			case 6:
				System.out.println("hp :" + hp + "  exp :" + exp + "  레벨 :" + lv);
				break;
			default:
				System.out.println("1 ~ 5번 사이의 번호를 입력해주세요 T.T");
				break;
			}
			
			System.out.println();
		}
	}
} 
