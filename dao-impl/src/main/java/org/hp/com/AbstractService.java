package org.hp.com;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.util.List;

/**
 * Created by borshtei on 28-Jul-14.
 *
 */
public class AbstractService<T> extends NamedParameterJdbcDaoSupport {

    protected List<T> query(String query, RowMapper<T> rowMapper, Object... args) {
        return getJdbcTemplate().query(query, rowMapper, args);
    }

}
