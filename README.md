### Как запустить проект
## Накатить дамп
Дамп лежит в корне проекта, в нем есть немного данных для проверки сделанного

## Запуск проекта и его проверка
Запустить можно командой sbt run
В проекте реализовано 4 метода:
1) Метод получения счета по его id \
```curl --location --request GET 'http://localhost:8080/account?id=395808b2-6bdf-4c50-9edc-f310cd10da71'```
2) Метод редактирования счета по его id (изменение суммы на счету) \
```curl --location --request POST  'http://localhost:8080/account/update?id=395808b2-6bdf-4c50-9edc-f310cd10da71&value=3000'```
3) Метод создания счета \
```curl --location --request POST  'http://localhost:8080/account/create?accountType=Saving'```
4) Метод получения истории по месяцам \
```curl --location --request GET  'http://localhost:8080/account/history?accountId=1f30a5de-e331-4b9d-90b6-1dd774188683'```

Для приведения кода в порядок подключил плагин sbt-scalafmt.