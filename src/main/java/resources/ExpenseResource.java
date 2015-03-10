package resources;

import com.alchemytec.codingtest.core.Expense;
import com.alchemytec.codingtest.db.ExpenseDAO;

import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Iterator;

@Path("/expenses")
@Produces(MediaType.APPLICATION_JSON)
public class ExpenseResource {
    private final ExpenseDAO dao;

    @GET
    public Iterator<Expense> list() {
        return dao.findAll();
    }

    @POST
    public long create(@Valid Expense expense) {
        if (expense.getId() != null)
            throw new IllegalStateException("Expense already have ID: " + expense);

        return dao.insert(expense);
    }

    public ExpenseResource(ExpenseDAO dao) { this.dao = dao; }
}
