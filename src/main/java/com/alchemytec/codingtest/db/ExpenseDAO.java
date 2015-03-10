package com.alchemytec.codingtest.db;

import com.alchemytec.codingtest.core.Expense;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Iterator;

@RegisterMapper(ExpenseMapper.class)
public interface ExpenseDAO {
    @SqlUpdate("create table if not exists expense (id bigserial primary key, date date, amount numeric(10, 2), reason varchar(255))")
    void createTableIfNeeded();

    @SqlUpdate("insert into expense (date, amount, reason) values (:exp.date, :exp.amount, :exp.reason)")
    @GetGeneratedKeys
    long insert(@BindBean("exp") Expense expense);

    @SqlQuery("select * from expense")
    Iterator<Expense> findAll();
}
