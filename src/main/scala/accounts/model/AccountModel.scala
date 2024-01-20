package accounts.model

import java.util.UUID

object AccountModel {

  import slick.jdbc.PostgresProfile.api._

  class AccountsTable(tag: Tag) extends Table[Account](tag, "accounts") {

    def accountId   = column[UUID]("id", O.PrimaryKey)
    def accountType = column[String]("account_type")
    def value       = column[Int]("value")

    def * = (
      accountId,
      accountType,
      value
    ).mapTo[Account]
  }

  val accounts = TableQuery[AccountsTable]

}
