package com.mahmud.service;

import com.mahmud.config.DBConfig;

import java.sql.*;

public class SequenceGenerator {
  public long getNext(SequenceType type) throws SQLException {
    Connection conn = null;

    try {
      conn = DBConfig.getConnection();
      conn.setAutoCommit(false);

      PreparedStatement selectStmt = conn.prepareStatement(
          "SELECT current_value FROM sequences WHERE seq_type = ? FOR UPDATE");
      selectStmt.setString(1, type.name());

      ResultSet rs = selectStmt.executeQuery();

      if (!rs.next()) {
        throw new RuntimeException("Sequence not found: " + type);
      }

      long current = rs.getLong("current_value");
      long next = current + 1;

      PreparedStatement updateStmt = conn.prepareStatement(
          "UPDATE sequences SET current_value = ? WHERE seq_type = ?");
      updateStmt.setLong(1, next);
      updateStmt.setString(2, type.name());
      updateStmt.executeUpdate();

      conn.commit();
      return next;

    } catch (Exception e) {
      if (conn != null)
        conn.rollback();
      throw e;
    } finally {
      if (conn != null)
        conn.close();
    }
  }
}
