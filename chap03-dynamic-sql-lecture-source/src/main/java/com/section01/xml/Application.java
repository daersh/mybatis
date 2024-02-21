package com.section01.xml;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("====== 마이바티스 동적 sql ======");
            System.out.println("1. if 확인하기");
            System.out.println("2. choose(when, otherwise) 확인하기");
            System.out.println("3. foreach 확인하기");
            System.out.println("4. trim(where,set)확인하기");
            System.out.println("9. 종료하기");
            System.out.print("메뉴 선택");
            int no = sc.nextInt();
            switch (no){
                case 1:
                    ifSubMenu();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 9:
                    System.out.println("프로그램 종료.");
                    return;
            }
        }while (true);

    }

    public static void ifSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do{
            System.out.println("====== if sub menu ======");
            System.out.println("1. 원하는 금액대에 적합한 추천 메뉴 목록 보여주기");
            System.out.println("2. 메뉴 이름 혹은 카테고리명으로 검색하여 메뉴 목록 보여주기");
            System.out.println("9. 이전 메뉴로 돌아가기");
            System.out.print("입력: ");
            int no = sc.nextInt();
            switch (no){
                case 1:
                    menuService.findMenuByPrice(inputPrice());
                    break;
                case 2:
                    menuService.searchMenu(inputSearchCriteria());
                    break;
                case 9:
                    return;
            }
        }while (true);
    }


    private static int inputPrice() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 가격대의 최대 금액을 입력하세요.");
        System.out.print("입력: ");
        return sc.nextInt();
    }

    private static SearchCriteria inputSearchCriteria() {
        Scanner sc = new Scanner(System.in);
        System.out.println("검색 기준 입력해주세요(name or category)");
        System.out.print("입력: ");
        String condition = sc.nextLine();
        System.out.print("검색어 입력: ");
        String value = sc.nextLine();
        return new SearchCriteria(condition,value);

    }


}
