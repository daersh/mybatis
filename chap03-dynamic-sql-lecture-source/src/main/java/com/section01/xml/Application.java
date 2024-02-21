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
                    trimSubMenu();
                    break;
                case 9:
                    System.out.println("프로그램 종료.");
                    return;
            }
        }while (true);

    }

    /**<h1>1. IF</h1>*/
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

    /**
     * <h1>2. Choose</h1>
     * */

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


    /**
     * <h1>3. FOR EACH</h1>
     * */
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



    private static void trimSubMenu() {
        Scanner sc = new Scanner(System.in);
        MenuService menuService = new MenuService();
        do {
            System.out.println("====== trim 서브 메뉴 ======");
            System.out.println("1. 검색 조건이 있는 경우 메뉴 코드로 조회, 단 없으면 전체 조회");
            System.out.println("2. 메뉴 혹은 카테고리로 검색. 단 메뉴와 카테고리 둘다 일치하는 경우도 검색하며 검색 조건이 없는 경우 전체 검색");
            System.out.println("3. 원하는 메뉴만 수정하기");
            System.out.println("9. 이전 메뉴로");
            System.out.print("메뉴 번호 입력: ");
            int no = sc.nextInt();
            switch (no){
                case 1:
                    menuService.searchMenuByCodeOrSearchAll(inputAllOrOne());
                    break;
                case 2:
                    menuService.searchMenuByNameOrCategory(inputSearchCriteriaMap());
                    break;
                case 3:

                    break;
                case 9:
                    return;
            }

        }while (true);

    }

    /**
     * SearchCriteria(condition과 value의 묶음) 개념을 이번에는 DTO가 아닌 Map으로 작성해 보자
     * */
    private static Map<String,Object> inputSearchCriteriaMap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건 입력: (category or name or both or none)");
        String condition = sc.nextLine();
        Map<String, Object> criteria = new HashMap<>();
        if("category".equals(condition)){
            System.out.print("검색할 카테고리 코드 입력: ");
            int categoryValue = sc.nextInt();
            criteria.put("categoryValue",categoryValue);
        }else if("name".equals(condition)){
            System.out.print("검색할 이름 입력: ");
            String nameValue = sc.nextLine();
            criteria.put("nameValue",nameValue);
        }else if("both".equals(condition)){
            System.out.print("검색할 이름 입력: ");
            String nameValue = sc.nextLine();
            System.out.print("검색할 카테고리 코드 입력: ");
            int categoryValue = sc.nextInt();

            criteria.put("nameValue",nameValue);
            criteria.put("categoryValue",categoryValue);
        }
        return criteria;
    }

    private static SearchCriteria inputAllOrOne() {
        Scanner sc = new Scanner(System.in);
        System.out.print("검색 조건을 입력하시겠습니까? (예 or 아니요)");
        boolean hasSearchValue = "예".equals(sc.nextLine())? true:false;
        SearchCriteria searchCriteria = new SearchCriteria();
        if(hasSearchValue){
            System.out.print("검색할 메뉴 코드 입력: ");
            String menuCode = sc.nextLine();
            searchCriteria.setCondition("menuCode");
            searchCriteria.setValue(menuCode);
        }

        return searchCriteria;
    }

}
