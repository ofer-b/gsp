import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by ofer on 29/07/14.
 *
 */

@Component
@Path("/")
public class TestResource {

    @GET
    @Produces("text/html")
    public String getIt() {
        return "hello world";
    }


}
