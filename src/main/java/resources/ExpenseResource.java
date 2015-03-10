package resources;

import com.alchemytec.codingtest.core.Expense;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.util.*;

@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseResource {
    private static final Logger logger = LoggerFactory.getLogger(ExpenseResource.class);

    private List<Expense> expenses = Collections.synchronizedList(new ArrayList<Expense>());
    {
        expenses.add(new Expense(1L, new Date(), BigDecimal.valueOf(10.5), "Reason 1"));
        expenses.add(new Expense(2L, new Date(), BigDecimal.valueOf(8.2), "Reason 2"));
        expenses.add(new Expense(3L, new Date(), BigDecimal.valueOf(19.1), "Reason 3"));
    }

    @GET
    public List<Expense> list() {
        return expenses;
    }

    @POST
    public Expense create(@Valid Expense expense) {
        expenses.add(expense);

        return expense;
    }

}
