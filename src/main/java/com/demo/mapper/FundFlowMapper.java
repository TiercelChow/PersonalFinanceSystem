package com.demo.mapper;

import com.demo.pojo.FundFlow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface FundFlowMapper {
    @Select("SELECT id,userId,flowMoney,type,source,createTime,fundDesc FROM" +
            " flow_of_funds WHERE flow_of_funds.userId=#{userId}")
    public List<FundFlow> selectFundFlowAll(Integer userId);
}
