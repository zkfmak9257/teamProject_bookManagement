package com.ohgiraffers.section01.list.run;

import com.ohgiraffers.section01.list.dto.UserDTO;
import com.ohgiraffers.section01.list.service.UserService;

import java.util.Scanner;

public class UserApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UserService userService = new UserService();

        while (true) {
            System.out.println("===== 사용자 메뉴 =====");
            System.out.println("1. 회원가입");
            System.out.println("2. 로그인");
            System.out.println("3. 전체 사용자 조회");
            System.out.println("9. 종료");
            System.out.print("메뉴 선택: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    String id = sc.nextLine();

                    System.out.print("PW: ");
                    String pw = sc.nextLine();

                    System.out.print("이름: ");
                    String name = sc.nextLine();

                    UserDTO newUser = new UserDTO(id, pw, name);
                    boolean result = userService.register(newUser);

                    System.out.println(result ? "가입 성공!" : "이미 존재하는 ID입니다!");
                    break;

                case 2:
                    System.out.print("ID: ");
                    String loginId = sc.nextLine();

                    System.out.print("PW: ");
                    String loginPw = sc.nextLine();

                    UserDTO loginUser = userService.login(loginId, loginPw);

                    System.out.println(loginUser == null ? "로그인 실패!" : "로그인 성공 → " + loginUser);
                    break;

                case 3:
                    System.out.println("=== 사용자 목록 ===");
                    for (UserDTO u : userService.getAllUsers()) {
                        System.out.println(u);
                    }
                    break;

                case 9:
                    System.out.println("프로그램 종료!");
                    return;

                default:
                    System.out.println("잘못 입력하셨습니다.");
            }
        }
    }
}
