package com.section01.xml;

import java.util.List;
import java.util.Map;

public interface MenuMapper {

    List<MenuDTO> selectMenuByPrice(int maxPrice);

    List<MenuDTO> searchMenu(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuBySupCategory(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByRandomMenuCode(List<Integer> integers);

    List<MenuDTO> searchMenuByCodeOrSearchAll(SearchCriteria searchCriteria);

    List<MenuDTO> searchMenuByNameOrCategory(Map<String, Object> searchCriteria);

    int updateMenu(Map<String, Object> criteria);
}
