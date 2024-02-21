package com.section01.xml;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MenuService {

    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice);
        System.out.println("service: ");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        System.out.println("service: ");
        menus.forEach(System.out::println);
        sqlSession.close();
    }

    public void searchMenuBySupCategory(SearchCriteria searchCriteria) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenuBySupCategory(searchCriteria);
        if(menus!=null && menus.size()>0)
            menus.forEach(System.out::println);
        else
            System.out.println("db 연동 실패 혹은 검색 결과 없음");
        sqlSession.close();
    }

    public void searchMenuByRandomMenuCode(List<Integer> integers) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO>menus = mapper.searchMenuByRandomMenuCode();
        if(menus!=null && menus.size()>0)
            menus.forEach(System.out::println);
        else
            System.out.println("db 연동 실패 혹은 검색 결과 없음");
        sqlSession.close();
    }
}
