import org.hp.com.dbcontext.DBContextImpl;
import org.hp.com.jdbc.JDBCTemplate;
import org.hp.com.jdbc.JDBCTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by borshtei on 13-Aug-14.
 *
 */
public class SchemaManager {

    private static final String[] SPRING_CONFIG_FILES = new String[]{"gsp-data-source-context.xml"};



    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(SPRING_CONFIG_FILES);
        JDBCTemplateFactory jdbcTemplateFactory = ctx.getBean(JDBCTemplateFactory.class);
        final DBContextImpl dbContext = new DBContextImpl("liquibase_management");

        JDBCTemplate jdbcTemplate = jdbcTemplateFactory.getJdbcTemplate(dbContext);
        //create new tetant schema
        jdbcTemplate.execute("drop user sampleapp cascade;");
        jdbcTemplate.execute("create user sampleapp identified by sampleapp;");
        jdbcTemplate.execute("grant connect, resource, create view to sampleapp;");

        //run upgrader
    }
}
