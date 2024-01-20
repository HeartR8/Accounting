package accounts.model

import enumeratum._

sealed trait AccountType extends EnumEntry

object AccountType extends Enum[AccountType] {

  val values = findValues

  case object Debit extends AccountType

  case object Credit extends AccountType

  case object Saving extends AccountType

}
