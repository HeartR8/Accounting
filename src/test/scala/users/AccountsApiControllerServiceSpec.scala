package users

import accounts.model.{HistoryRecord, HistoryReport}
import accounts.service.AccountsApiControllerService
import com.softwaremill.macwire._
import common.mock.MockWiring
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.time.LocalDateTime
import java.util.UUID
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.util.Success

class AccountsApiControllerServiceSpec extends AnyFlatSpec with Matchers with MockWiring {

  "registerUser" should "register user if everything is ok" in {
    val sampleUUID = UUID.randomUUID()
    val sampleTime = LocalDateTime.now()

    when(mockHistoryDBService.getAccountHistory(sampleUUID)).thenReturn(Future.successful(
      List(HistoryRecord(id = sampleUUID, accountId = sampleUUID, value = 100, updateTime = sampleTime))
    ))

    val result = accountsApiControllerService.getAccountHistoryByMonth(sampleUUID)

    Await.result(result, 5.seconds)
    verify(mockHistoryDBService).getAccountHistory(sampleUUID)
    result.value.get shouldBe Success(List(HistoryReport(sampleUUID, 100)))
  }

  val accountsApiControllerService = wire[AccountsApiControllerService]

}
