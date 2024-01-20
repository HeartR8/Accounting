package accounts.model

import java.sql.Timestamp
import java.time.LocalDateTime
import java.util.UUID

object HistoryModel {

  import slick.jdbc.PostgresProfile.api._

  implicit val localDateTimeToTimestamp = MappedColumnType.base[LocalDateTime, Timestamp](
    l => Timestamp.valueOf(l),
    d => d.toLocalDateTime
  )

  class HistoryTable(tag: Tag) extends Table[HistoryRecord](tag, "history") {
    def id         = column[UUID]("id", O.PrimaryKey)
    def accountId  = column[UUID]("account_id")
    def value      = column[Int]("value")
    def updateTime = column[LocalDateTime]("update_datetime", O.SqlType("DATETIME"))(localDateTimeToTimestamp)

    def * = (
      id,
      accountId,
      value,
      updateTime
    ).mapTo[HistoryRecord]
  }

  val history = TableQuery[HistoryTable]

}
