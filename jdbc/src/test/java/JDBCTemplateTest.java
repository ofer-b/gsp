import org.hp.com.jdbc.ConnectionProperties;
import org.hp.com.jdbc.JDBCTemplateFactory;
import org.hp.com.jdbc.JDBCTemplate;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by borshtei on 28-Jul-14.
 *
 */
@ContextConfiguration("classpath*:gsp-*-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JDBCTemplateTest extends AbstractJUnit4SpringContextTests {

    @Autowired
    JDBCTemplateFactory jdbcTemplateFactory;

    @org.junit.Test
    public void testQuery() throws Exception {

        //todo: the following should be taken from a config file
        final String JDBC_URL = "jdbc:oracle:thin:@localhost:1521:XE";
        final String user = "system";
        final String password = "manager";


        final ConnectionProperties connectionProperties = new ConnectionProperties(JDBC_URL, user, password);
        JDBCTemplate jdbcTemplate = jdbcTemplateFactory.getJdbcTemplate(connectionProperties);
        int i = jdbcTemplate.queryForInt("select 1 from users", new Object[]{});


    }
}
