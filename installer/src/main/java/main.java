import org.hp.com.jdbc.JDBCTemplate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by borshtei on 13-Aug-14.
 *
 */
public class main {

    @Autowired
    static JDBCTemplate jdbcTemplate;

    public static void main(String[] args) {
        //create new tetant schema
        jdbcTemplate.execute("drop user sampleapp cascade;");
        jdbcTemplate.execute("create user sampleapp identified by sampleapp;");
        jdbcTemplate.execute("grant connect, resource, create view to sampleapp;");

        //run upgrader
    }
}
