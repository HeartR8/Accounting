package accounts.controller

import accounts.model.{AccountType, AccountsFormat}
import accounts.service.AccountsApiControllerService
import akka.http.scaladsl.server.Route
import common.directives.CommonDirectives

import java.util.UUID
import scala.concurrent.ExecutionContext

class AccountsApiController(accountsApiControllerService: AccountsApiControllerService)(implicit
    executionContext: ExecutionContext
) extends CommonDirectives
    with AccountsFormat {

  val route: Route =
    path("account") {
      getAccount
    } ~
      path("account" / "update") {
        updateAccountValue()
      } ~
      path("account" / "create") {
        createAccount()
      } ~
      path("account" / "history") {
        getHistoryByMonth()
      }

  def getAccount: Route = {
    get {
      parameters(Symbol("id").as[UUID]) { id =>
        withErrorHandling {
          accountsApiControllerService.getAccount(id)
        }
      }
    }
  }

  def updateAccountValue(): Route = {
    post {
      parameters(Symbol("id").as[UUID], Symbol("value").as[Int]) { (id, value) =>
        withErrorHandling {
          accountsApiControllerService.updateAccountValue(id, value)
        }
      }
    }
  }

  def createAccount(): Route = {
    post {
      parameters(Symbol("accountType").as[String]) { (accountType) =>
        withErrorHandling {
          accountsApiControllerService.createAccount(AccountType.withName(accountType))
        }
      }
    }
  }

  def getHistoryByMonth(): Route = {
    get {
      parameters(Symbol("accountId").as[UUID]) { accountId =>
        withErrorHandling {
          accountsApiControllerService.getAccountHistoryByMonth(accountId)
        }
      }
    }
  }
}
