import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by borshtei on 28-Jul-14.
 *
 */
public class JDBCTemplateFactory {

    public JDBCTemplate getInstance(DataSource dataSource){
        return new JDBCTemplateImpl(dataSource);
    }

}
