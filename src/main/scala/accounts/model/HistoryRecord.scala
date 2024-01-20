package accounts.model

import java.time.LocalDateTime
import java.util.UUID

case class HistoryRecord(id: UUID, accountId: UUID, value: Int, updateTime: LocalDateTime)
