package com.section01.xml;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

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

        List<MenuDTO>menus = mapper.searchMenuByRandomMenuCode(integers);
        if(menus!=null && menus.size()>0)
            menus.forEach(System.out::println);
        else
            System.out.println("db 연동 실패 혹은 검색 결과 없음");
        sqlSession.close();
    }

    public void searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.searchMenuByCodeOrSearchAll(searchCriteria);

        if(menus!=null && menus.size()>0)
            menus.forEach(System.out::println);
        else
            System.out.println("db 연동 실패 혹은 검색 결과 없음");
        sqlSession.close();
    }

    public void searchMenuByNameOrCategory(Map<String, Object> searchCriteria) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper menuMapper = sqlSession.getMapper(MenuMapper.class);

        List<MenuDTO> menus = menuMapper.searchMenuByNameOrCategory(searchCriteria);
        if(menus!=null && menus.size()>0)
            menus.forEach(System.out::println);
        else
            System.out.println("db 연동 실패 혹은 검색 결과 없음");
        sqlSession.close();
    }

    public void modifyMenu(Map<String, Object> criteria) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
       int result = mapper.updateMenu(criteria);
       if(result>0){
           System.out.println("정보 메뉴 수정 완료.");
           sqlSession.commit();
       }else{
           System.out.println("메뉴 정보 변경 실패");
           sqlSession.rollback();
       }
       sqlSession.close();
    }
}
