import org.hp.com.dbcontext.DBContext;
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

    public static final DBContext DB_CONTEXT = new DBContext() {
        @Override
        public DbType getDbType() {
            return DbType.Oracle;
        }

        @Override
        public String getDbSchemaName() {
            return "sampleapp";
        }
    };
    @Autowired
    JDBCTemplateFactory jdbcTemplateFactory;

    @org.junit.Test
    public void testQuery() throws Exception {
        JDBCTemplate jdbcTemplate = jdbcTemplateFactory.getJdbcTemplate(DB_CONTEXT);
        int i = jdbcTemplate.queryForInt("select 1 from users", new Object[]{});


    }
}
