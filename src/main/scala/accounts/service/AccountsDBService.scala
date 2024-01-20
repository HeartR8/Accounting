package accounts.service

import accounts.model.Account
import accounts.model.AccountModel.accounts
import slick.jdbc.PostgresProfile.api._

import java.util.UUID
import scala.concurrent.Future

class AccountsDBService(db: Database) {

  def getAccountById(id: UUID): Future[Option[Account]] = {
    val query = accounts.filter(_.accountId === id).result.headOption
    db.run(query)
  }

  def createOrUpdateAccount(account: Account): Future[Int] = {
    val query = accounts.insertOrUpdate(account)
    db.run(query)
  }
}
