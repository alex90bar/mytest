# MytestApplication
Описание проекта

MytestApplication - это учебный проект на Spring Boot, с использованием Spring Security на Jwt-токенах.
Порт приложения: 8089.

Приложение упаковано в докер-контейнер. 
При запуске контейнера БД заполняется тестовыми данными, можно проходить авторизацию с использованием name=user, password=pass.

Скрипты для запуска приложения и БД:
```
docker network create my-network
docker run --network=my-network --name postgres -e POSTGRES_DB=postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -p 5435:5432 -d postgres
docker run --network=my-network --rm -p 8089:8089 -e DATABASE_URL=postgresql://postgres:5432/postgres alex90bar/mytest:latest

```

Список эндпоинтов:

http://localhost:8089/api/auth/signup - регистрация нового пользователя, запрос POST в формате JSON:

`{
"name": "username",
"password": "password"
}`

http://localhost:8089/api/auth/login - Аутентификация и авторизация, получение jwt-токена, запрос POST в формате JSON:

`{
"name": "username",
"password": "password"
}`

http://localhost:8089/api/message - Публикация нового сообщения, требует указанный в заголовке Authorization Bearer-токен, в формате Bearer_ + tokenValue (например, Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjU5NjE2OTg4LCJleHAiOjE2NjA4MjY1ODh9.FCgVbAzmWrIFos6Q-60YK67KbFyl-0joLyS39qLGGLE), запрос POST в формате JSON:

`{
"name": "user",
"message": "some text"
}
`

http://localhost:8089/api/message - Получение последних 10 сообщений, отсортированных по убыванию, требует указанный в заголовке Authorization Bearer-токен, в формате Bearer_ + tokenValue (например, Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjU5NjE2OTg4LCJleHAiOjE2NjA4MjY1ODh9.FCgVbAzmWrIFos6Q-60YK67KbFyl-0joLyS39qLGGLE), запрос POST в формате JSON:

`{
"name": "user",
"message": "history 10"
}
`

Запросы для проверки работоспособности через curl:

*Получение jwt-токена с использованием credentials name = user, password = pass:*

`curl -X POST http://localhost:8089/api/auth/login -H 'Content-Type: application/json' -d '{"name":"user","password":"pass"}'`

*Регистрация нового пользователся с использованием credentials name = userNew, password = passNew:*

`curl -X POST http://localhost:8089/api/auth/signup -H 'Content-Type: application/json' -d '{"name":"userNew","password":"passNew"}'`

*Публикация нового сообщения, name = user, message = some text, требует указанный в заголовке Authorization Bearer-токен:*

`curl -X POST http://localhost:8089/api/message -H "Authorization: Bearer_eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjU5NjE2OTg4LCJleHAiOjE2NjA4MjY1ODh9.FCgVbAzmWrIFos6Q-60YK67KbFyl-0joLyS39qLGGLE" -H 'Content-Type: application/json' -d '{"name":"user","message":"some text"}'`

*Получение последних 10 сообщений, отсортированных по убыванию, требует указанный в заголовке Authorization Bearer-токен:*

`curl -X POST http://localhost:8089/api/message -H "Authorization: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNjU5NjE2OTg4LCJleHAiOjE2NjA4MjY1ODh9.FCgVbAzmWrIFos6Q-60YK67KbFyl-0joLyS39qLGGLE" -H 'Content-Type: application/json' -d '{"name":"user","message":"history 10"}'`
