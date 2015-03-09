package resources;

import com.alchemytec.codingtest.core.Expense;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
public class ExpensesResource {

    @GET
    public List<Expense> list() {
        return Arrays.asList(
                new Expense(1L, new Date(), BigDecimal.valueOf(10.5), "Reason 1"),
                new Expense(2L, new Date(), BigDecimal.valueOf(8.2), "Reason 2"),
                new Expense(3L, new Date(), BigDecimal.valueOf(19.1), "Reason 3")
        );
    }

}
