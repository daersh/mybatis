package com.section01.xml;

public class MenuDTO {
    private int menuCode;
    private String menuName;
    private int menuPrice;
    private int categoryCode;
    private String orderableStatus;

    public MenuDTO() {}

    public MenuDTO(int menuCode, String menuName, int menuPrice, int categoryCode, String orderableStatus) {
        this.menuCode = menuCode;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.categoryCode = categoryCode;
        this.orderableStatus = orderableStatus;
    }
    /*설명. 마이바티스는 게터 세터가 없어도 자바의 리플렉션 기술을 통해 필드에 접근한다.
    *  스프링의 컨틀로러에서 커맨드 객체로도 사용되므로 실제 구현 시 게터 세터를 만들어서 쓸 것*/

    @Override
    public String toString() {
        return "MenuDTO{" +
                "menuCode=" + menuCode +
                ", menuNmae='" + menuName + '\'' +
                ", menuPrice=" + menuPrice +
                ", categoryCode=" + categoryCode +
                ", orderableStatus='" + orderableStatus + '\'' +
                '}';
    }
}
