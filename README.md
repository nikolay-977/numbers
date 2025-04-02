# Spring Boot Numbers API

## Описание

Spring Boot Numbers API — это WEB-сервис с одним end-point-ом /api/numbers,
которое принимает список целых чисел и возвращает новый список, в котором каждое число увеличено на 1.
API обрабатывает различные сценарии, включая отрицательные числа, нули и дубликаты.

## Технологии

- Java 17
- Spring Boot 3.4.4
- Gradle
- JUnit 5
- AssertJ

## Запуск приложения

```shell script
./gradlew build -x check
 ```

```shell script
./gradlew bootRun
 ```

## Запуск тестов

```shell script
./gradlew test
 ```
