package com.section01.xml;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.section01.xml.Template.GetSqlSession;

public class MenuService {
    MenuRepository menuRepository = new MenuRepository();

    public void findMenuByPrice(int maxPrice) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.selectMenuByPrice(maxPrice);
        System.out.println("service: ");
        menus.forEach(System.out::println);

    }

    public void searchMenu(SearchCriteria searchCriteria) {
        SqlSession sqlSession = Template.GetSqlSession();
        MenuMapper mapper = sqlSession.getMapper(MenuMapper.class);
        List<MenuDTO> menus = mapper.searchMenu(searchCriteria);
        System.out.println("service: ");
        menus.forEach(System.out::println);
    }
}
