package org.hp.com.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by borshtei on 24-Jul-14.
 *
 */
public class JDBCTemplateImpl extends JdbcTemplate implements JDBCTemplate  {

    private final JdbcTemplate jdbcTemplate;

    JDBCTemplateImpl(DataSource dataSource) {

        jdbcTemplate = new JdbcTemplate(dataSource);

    }



    @Override
    public int queryForInt(String sql, Object[] args) {

        return jdbcTemplate.queryForObject(sql, args, Integer.class);
    }

    @Override
    public void execute(String sql) {
        jdbcTemplate.execute(sql);
    }

}
