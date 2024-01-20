package accounts.service

import accounts.model.{Account, AccountType, HistoryReport}

import java.util.UUID
import scala.concurrent.{ExecutionContext, Future}

class AccountsApiControllerService(accountsDBService: AccountsDBService, historyDBService: HistoryDBService)(implicit executionContext: ExecutionContext) {

  def getAccount(id: UUID): Future[Option[Account]] = {
    for {
      account <- accountsDBService.getAccountById(id)
    } yield account
  }

  def updateAccountValue(id: UUID, value: Int): Future[Unit] = {
    for {
      account <- accountsDBService.getAccountById(id)
      updatedAccount = account.get.copy(value = value)
      _ <- accountsDBService.createOrUpdateAccount(updatedAccount)
      _ <- historyDBService.logChange(updatedAccount)
    } yield None
  }

  def createAccount(accountType: AccountType): Future[Option[Account]] = {
    val id = UUID.randomUUID()
    for {
      _ <- accountsDBService.createOrUpdateAccount(
        Account(accountType = accountType.entryName, id = id, value = 0)
      )
      account <- accountsDBService.getAccountById(id)
      _ <- historyDBService.logChange(account.get)
    } yield account
  }

  def getAccountHistoryByMonth(id: UUID): Future[Iterable[HistoryReport]] = {
    for {
      history <- historyDBService.getAccountHistory(id).map(_.groupBy(_.updateTime.getMonthValue).map {
        case (_, value) => value.maxBy(_.updateTime)
      })
    } yield history.map(h => new HistoryReport(h.accountId, h.value))
  }
}
