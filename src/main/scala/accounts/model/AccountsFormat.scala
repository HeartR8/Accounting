package accounts.model

import common.marhallers.JsonSupport

trait AccountsFormat extends JsonSupport {
  implicit val accountFormat       = jsonFormat3(Account)
  implicit val historyRecordFormat = jsonFormat4(HistoryRecord)
  implicit val historyReportFormat = jsonFormat2(HistoryReport)
}
