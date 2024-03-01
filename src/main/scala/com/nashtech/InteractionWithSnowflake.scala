package com.nashtech

import com.typesafe.config.ConfigFactory
import java.sql.Statement

object InteractionWithSnowflake {
  private val config = ConfigFactory.load("snowflake.conf")

  private val statement: Statement = Connection.connection().createStatement()

  def createDatabase(): String = {
    val database = config.getString("snowflake.database")
    statement.execute(s"CREATE DATABASE IF NOT EXISTS $database")
    statement.execute(s"USE $database")
    "Database Created Successfully"
  }

  def createSchema(): String = {
    val schema = config.getString("snowflake.schema")
    statement.execute(s"CREATE SCHEMA IF NOT EXISTS $schema")
    statement.execute(s"USE SCHEMA $schema")
    "Schema Created Successfully"
  }

  def createTable(): String = {
    val table = config.getString("snowflake.table")
    statement.execute(s"CREATE TABLE IF NOT EXISTS $table(id INT, name VARCHAR(50), role VARCHAR(50))")
    "Table Created Successfully"
  }

  def insertDataToTable(sampleData: List[List[String]]): String = {
    val table = config.getString("snowflake.table")
    sampleData.foreach { record =>
      statement.execute(s"Insert INTO $table VALUES ('${record.head}', '${record(1)}', '${record(2)}')")
    }
    "Data Inserted Successfully !!!"
  }
}
