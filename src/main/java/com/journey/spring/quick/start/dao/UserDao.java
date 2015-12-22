package com.journey.spring.quick.start.dao;

import com.journey.spring.quick.start.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 访问User的DAO
 * Created by zhangyuan on 15/12/16.
 */
@Repository //通过Spring注解定义一个DAO
public class UserDao {

    @Autowired //自动注入JdbcTemplate的Bean
    private JdbcTemplate jdbcTemplate;

    public int getMatchCount(String userName, String password) {
        String sqlStr = "select count(1) from t_user " +
                "where user_name = ? and password = ?";
        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName, password}, Integer.class);
    }

    public User findUserByUserName(String userName) {
        String sqlStr = "select user_id, user_name, credits " +
                "from t_user where user_name = ?";
        return jdbcTemplate.queryForObject(sqlStr, new Object[]{userName}, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(resultSet.getString("user_name"));
                user.setCredits(resultSet.getInt("credits"));
                return user;
            }
        });

    }

    public void updateLoginInfo(User user) {
        String sqlStr = "update t_user set last_visit = ?, last_ip = ?, credits = ? " +
                "where user_id = ?";
        jdbcTemplate.update(sqlStr, user.getLastVisit(), user.getLastIp(), user.getCredits(),user.getUserId());
    }


}
