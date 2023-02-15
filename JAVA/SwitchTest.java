package prj2_2;

public class SwitchTest { // 제어문 : switch
	public static void main(String[] args) {
		int x = 4;

		switch (x) {
		case 1:
			System.out.println("x는 1입니다.");
			break;
		case 2:
			System.out.println("x는 2입니다.");
			break;
		case 3:
			System.out.println("x는 3입니다.");
			break;
		default:
			System.out.println("x는 범위 밖입니다.");
		}

		String day = "일요일";

		switch (day) {
		case "월요일":
			System.out.println("월요일입니다.");
			break;
		case "화요일":
			System.out.println("화요일입니다.");
			break;
		case "수요일":
			System.out.println("수요일입니다.");
			break;
		case "목요일":
			System.out.println("목요일입니다.");
			break;
		case "금요일":
			System.out.println("금요일입니다.");
			break;
		case "토요일":
			System.out.println("토요일입니다.");
			break;
		case "일요일":
			System.out.println("일요일입니다.");
			break;
		default:
			System.out.println("정확한 요일을 입력해주세요.");
		}

	}
}
