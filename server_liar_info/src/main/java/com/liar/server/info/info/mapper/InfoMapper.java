package com.liar.server.info.info.mapper;

import com.liar.server.info.info.daoBean.Info;
import com.liar.server.user.user.provider.InfoMapperProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * 用户
 * @author liumengwei
 * @since 2018/5/30
 */
@Mapper
public interface InfoMapper {
    @Insert("insert into info(username, password) values(#{username}, #{password})")
    int insert(@Param("username") String username, @Param("password") String password);

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return Info
     * @author liumengwei
     * @since 2018/5/30
     */
    @Select("select id, username, password from info where username = #{username} and password = #{password}")
    Info login(@Param("username")String username, @Param("password")String password);

    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return Info
     * @author liumengwei
     * @since 2018/5/30
     */
    @SelectProvider(type = InfoMapperProvider.class, method = "findByName")
    String login1(@Param("username")String username, @Param("password")String password);

    @Select("select * from info where username = #{username} and password = #{password}")
    Info findWithLoginnameAndPassword(@Param("username")String username, @Param("password") String password);
}

