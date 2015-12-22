package com.journey.spring.quick.start.dao;

import com.journey.spring.quick.start.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * 用户登录日志DAO
 * Created by zhangyuan on 15/12/16.
 */
@Repository
public class LoginLogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLoginLog(LoginLog loginLog) {
        String sqlStr = "insert into t_login_log(user_id, ip, login_datetime) " +
                "values(?, ?, ?)";
        jdbcTemplate.update(sqlStr, loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate());
    }

}

