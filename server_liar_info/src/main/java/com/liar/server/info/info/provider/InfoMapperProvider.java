package com.liar.server.user.user.provider;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class InfoMapperProvider {
    public String findByName(String username, String password) {
        StringBuffer sql = new StringBuffer("SELECT username FROM info");
        if (StringUtils.isEmpty(username)) {
            return sql.toString();
        }
        sql.append(" WHERE username = '" + username + "' and password = '" + password + "'");
        return sql.toString();


//        return new SQL() {
//            {
//                SELECT("username");
//                FROM("info");
//                WHERE(" username = '" + username + "' and password = '" + password + "'");
//            }
//        }.toString();


    }
}
