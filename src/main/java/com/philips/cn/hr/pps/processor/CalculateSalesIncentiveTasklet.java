package com.philips.cn.hr.pps.processor;

import com.philips.cn.hr.pps.domain.Employee;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.math.BigDecimal;

/**
 * Created by kvn on 2/12/15.
 */
public class CalculateSalesIncentiveTasklet implements Tasklet {


    private DataSource dataSource;

    private String sql_50;
    private String sql_60;
    private String sql_70;
    private String sql_80;

    public String getSql_50() {
        return sql_50;
    }

    public void setSql_50(String sql_50) {
        this.sql_50 = sql_50;
    }

    public String getSql_60() {
        return sql_60;
    }

    public void setSql_60(String sql_60) {
        this.sql_60 = sql_60;
    }

    public String getSql_70() {
        return sql_70;
    }

    public void setSql_70(String sql_70) {
        this.sql_70 = sql_70;
    }

    public String getSql_80() {
        return sql_80;
    }

    public void setSql_80(String sql_80) {
        this.sql_80 = sql_80;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public RepeatStatus execute(StepContribution stepContribution, ChunkContext chunkContext) throws Exception {

        new JdbcTemplate(getDataSource()).execute(this.getSql_50());
        new JdbcTemplate(getDataSource()).execute(this.getSql_60());
        new JdbcTemplate(getDataSource()).execute(this.getSql_70());
        new JdbcTemplate(getDataSource()).execute(this.getSql_80());

        return RepeatStatus.FINISHED;
    }
}
