package com.section01.xml;

import java.util.*;

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
                    chooseSubMenu();
                    break;
                case 3:
                    foreachSubMenu();
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



    public static void chooseSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("====== choose 서브 메뉴 ======");
            System.out.println("1. 카테고리 상위 분류별 메뉴 보여주기(식사, 음력, 디저트)");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuService.searchMenuBySupCategory(inputSupCategory());
                    break;
                case 9:
                    return;
            }

        }while (true);
    }

    private static SearchCriteria inputSupCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.print("상위 분류 입력(식사, 음료, 디저트): ");
        String value= sc.nextLine();

        return new SearchCriteria("category",value);
    }

    private static void foreachSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("====== foreach 서브 메뉴 ======");
            System.out.println("1. 랜덤 메뉴 5개 추출해서 조회하기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();

            switch (no){
                case 1:
                    menuService.searchMenuByRandomMenuCode(generateRandomMenuCodeList());
                    break;
                case 9:
                    return;
            }

        }while (true);
    }

    /*1~21까지 5개의 중복되지 않는 번호 생성하여 리스트에 쌓아 반환하는 메서드*/
    private static List<Integer> generateRandomMenuCodeList(){
        List<Integer> list;
        Set<Integer> set = new TreeSet<>();
        while (set.size()<5){
            int temp = ((int)(Math.random()*21)+1);
            set.add(temp);
        }
        list = new ArrayList<>(set);
        return list;
    }
}
