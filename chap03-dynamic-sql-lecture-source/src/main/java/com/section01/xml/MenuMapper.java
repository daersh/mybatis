package com.section01.xml;

import java.util.List;

public interface MenuMapper {

    List<MenuDTO> selectMenuByPrice(int maxPrice);
}