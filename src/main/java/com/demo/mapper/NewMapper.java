package com.demo.mapper;


import com.demo.pojo.New;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewMapper {
    @Select("select * from news")
    public List<New> selectNewAll();
}
