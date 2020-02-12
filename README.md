# Конвертер валют
 #### Рекомендации для сборки и запуска проекта:
  - Создать сервере БД пользователия *networker* с паролем *sQzMaXd?PMqp8bZwafea*
  или в файле *application.properties* заменить учетные данные пользователия
  ```sql
CREATE ROLE networker WITH
	LOGIN
	NOSUPERUSER
	CREATEDB
	NOCREATEROLE
	INHERIT
	REPLICATION
	CONNECTION LIMIT -1
	PASSWORD 'xxxxxx';
```
  - Создать на сервере БД пустую базу данных *currency_converter*
  ```sql
CREATE DATABASE currency_converter
    WITH 
    OWNER = networker
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
```
  - Создание исполняемого jar командой  *mvn package spring-boot:repackage*

