# Микросервис Ведения реестров для соц обеспечения

## Установка, настройка и запуск

### Зависимости

* Java OpenJDK 11
* SpringBoot 2.1.4.RELEASE
* Gradle 5.4.1
* Docker, Docker-compose 
* PostgreSQL 11.2
* JOOQ 3.11.11
* Lombok 1.18.6


### Параметры приложения

Все конфигурации проекта лежат в файле application.yaml
Номер версии version.txt


### Сборка приложения

Проект собирается gradle’ом из корневой папки при помощи скрипта:
scripts/build.sh  - Linux
scripts/build.bat - Windows


### Запуск приложения

Запустить приложение можно выполнив скрипт из корневой папки:
scripts/start.sh  - Linux 
scripts/start.bat - Windows


Для локального запуска БД можно последовательно выполнить команды:
```
cd docker
docker pull cocos-registry.is-mis.ru/infra-images/postgres-jsquery
docker-compose -f docker-compose-dev.yaml up -d
```

### Остановка приложения

Остановить приложение можно выполнив команду:
```
gradlew composeDown
```

### Скрипт для сборки в Jenkins (в разработке)

script/pipeline.sh

### Запуск юнит-тестов
```
gradlew test
```
