package accounts.service

import accounts.model.HistoryRecord
import accounts.model.Account
import accounts.model.HistoryModel.history
import slick.jdbc.PostgresProfile.api._

import java.time.LocalDateTime
import java.util.UUID
import scala.concurrent.Future

class HistoryDBService(db: Database) {
  def logChange(account: Account): Future[Int] = {
    val query = history.insertOrUpdate(
      HistoryRecord(
        id = UUID.randomUUID(),
        accountId = account.id,
        value = account.value,
        updateTime = LocalDateTime.now()
      )
    )
    db.run(query)
  }

  def getAccountHistory(id: UUID): Future[Seq[HistoryRecord]] = {
    val query = history.filter(_.accountId === id).result
    db.run(query)
  }
}
