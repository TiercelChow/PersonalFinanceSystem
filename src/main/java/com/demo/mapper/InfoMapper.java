package com.demo.mapper;

import com.demo.pojo.Info;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InfoMapper {
    @Select("SELECT sendId,receiveId,username,info.id id,createTime,title,infoDesc,info.status status " +
            "FROM info ,admin WHERE receiveId=#{loginUser} AND admin.id=sendId")
    public List<Info> SelectInfoById(Integer loginUser);

    @Update("UPDATE info SET status=1 WHERE id=#{id}")
    public int UpdateInfoStatus(Info info);

    @Delete("DELETE FROM info WHERE id=#{id}")
    public int DeleteInfo(Info info);

    @Insert("INSERT INTO info (sendId,receiveId,createTime,title,infoDesc,status) " +
            "VALUES (#{sendId},#{receiveId},CURDATE(),#{title},#{infoDesc},0)")
    public int addInfo(Info info);
}
