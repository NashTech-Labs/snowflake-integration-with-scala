package com.nashtech

import java.sql.{Connection, DriverManager, SQLException}
import scala.util.{Failure, Success, Try}
import com.typesafe.config.ConfigFactory

object Connection {
  private val config = ConfigFactory.load("snowflake.conf")

  private val url = config.getString("snowflake.url")
  private val port = config.getString("snowflake.port")
  private val username = config.getString("snowflake.username")
  private val password = config.getString("snowflake.password")

  private val connectionString = s"jdbc:snowflake://$url:$port/?user=$username&password=$password"

  def connection(): Connection = {
    Try(DriverManager.getConnection(connectionString)) match {
      case Success(conn) => conn
      case Failure(_) => throw new SQLException()
    }
  }
}
