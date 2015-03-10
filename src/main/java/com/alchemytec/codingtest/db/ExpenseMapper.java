package com.alchemytec.codingtest.db;

import com.alchemytec.codingtest.core.Expense;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExpenseMapper implements ResultSetMapper<Expense> {
    @Override
    public Expense map(int i, ResultSet rs, StatementContext statementContext) throws SQLException {
        Expense exp = new Expense();
        exp.setId(rs.getLong("id"));
        exp.setDate(rs.getDate("date"));
        exp.setAmount(rs.getBigDecimal("amount"));
        exp.setReason(rs.getString("reason"));

        return exp;
    }
}
