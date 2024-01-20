package common.mock

import accounts.service.{AccountsApiControllerService, AccountsDBService, HistoryDBService}
import org.mockito.MockitoSugar
import wirings.ConcurrentModule

trait MockWiring extends MockitoSugar with ConcurrentModule {
  val mockHistoryDBService = mock[HistoryDBService]
  val mockAccountsDBService = mock[AccountsDBService]
  val mockAccountsApiControllerService = mock[AccountsApiControllerService]
}
