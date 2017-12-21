package com.lanou3g.test.util;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class SonQueryRunner extends QueryRunner{
    /*
        为了关闭Connection
     */
    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh) throws SQLException {

        T query = super.query(conn, sql, rsh);
        conn.close();
        return query;
    }

    @Override
    public <T> T query(Connection conn, String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        conn.setAutoCommit(false);

        T query = super.query(conn, sql, rsh, params);
        conn.commit();
        conn.close();

        return query;
    }

    @Override
    public int update(Connection conn, String sql, Object... params) throws SQLException {

        int update = super.update(conn, sql, params);
        conn.close();
        return update;
    }
}

