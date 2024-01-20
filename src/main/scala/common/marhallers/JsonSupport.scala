package common.marhallers

import accounts.model.AccountType
import akka.http.scaladsl.marshallers.sprayjson.SprayJsonSupport
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat}

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.UUID

trait JsonSupport extends SprayJsonSupport with DefaultJsonProtocol {
  implicit object UUIDFormat extends JsonFormat[UUID] {
    def write(uuid: UUID) = JsString(uuid.toString)

    def read(value: JsValue) = {
      value match {
        case JsString(uuid) => UUID.fromString(uuid)
        case _              => throw DeserializationException("Expected hexadecimal UUID string")
      }
    }
  }

  implicit object AccountTypeFormat extends JsonFormat[AccountType] {
    def write(accountType: AccountType) = JsString(accountType.toString)

    def read(value: JsValue) = {
      value match {
        case JsString(accountType) => AccountType.withName(accountType)
        case _                     => throw DeserializationException("Expected valid account type")
      }
    }
  }

  implicit object LocalDateTimeFormat extends JsonFormat[LocalDateTime] {
    def write(localDateTime: LocalDateTime) = JsString(localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))

    def read(value: JsValue) = {
      value match {
        case JsString(localDateTime) =>
          LocalDateTime.parse(localDateTime, DateTimeFormatter.ISO_LOCAL_DATE_TIME)
        case _ => throw DeserializationException("Expected valid account type")
      }
    }
  }
}
