package com.nashtech

object DriverApp extends App {

  private val sampleData =
    List(
      List("1", "Manish", "Software Consultant"),
      List("2", "Sant Narayan Singh", "Software Consultant"),
      List("3", "Tushar Dhiman", "Software Consultant"),
      List("4", "Ajit Kumar", "Software Consultant"),
      List("5", "Amit Kumar", "Senior Software Consultant"),
      List("6", "Akhil Trivedi", "Software Consultant"),
    )

  println(InteractionWithSnowflake.createDatabase())
  println(InteractionWithSnowflake.createSchema())
  println(InteractionWithSnowflake.createTable())
  println(InteractionWithSnowflake.insertDataToTable(sampleData))
}
