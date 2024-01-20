package wirings

import accounts.service.{AccountsDBService, HistoryDBService}

trait DatabaseModule {
  import slick.jdbc.PostgresProfile.api._
  lazy val accountingDb     = Database.forConfig("accountingDb")
  lazy val accountDBService = new AccountsDBService(accountingDb)
  lazy val historyDBService = new HistoryDBService(accountingDb)

}
