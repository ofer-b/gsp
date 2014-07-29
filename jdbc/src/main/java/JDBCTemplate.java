/**
 * Created by borshtei on 24-Jul-14.
 *
 */
public interface JDBCTemplate {

    int queryForInt(String sql, Object[] args);
}
