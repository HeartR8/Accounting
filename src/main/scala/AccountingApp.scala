import accounts.controller.AccountsApiController
import accounts.service.AccountsApiControllerService
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import com.softwaremill.macwire._
import wirings.{ConcurrentModule, DatabaseModule}

object AccountingApp extends App with ConcurrentModule with DatabaseModule {

  lazy val accountsApiControllerService = wire[AccountsApiControllerService]
  lazy val accountsApiController        = wire[AccountsApiController]

  Http().bindAndHandle(
    accountsApiController.route,
    "localhost",
    8080
  )

}
