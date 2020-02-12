# Конвертер валют
 #### Рекомендации для сборки и запуска проекта:
  - JDK 11
  - Создать сервере БД пользователия **networker** с паролем **sQzMaXd?PMqp8bZwafea**
  или в файле **application.properties** заменить учетные данные пользователия
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
  - Создать на сервере БД пустую базу данных **currency_converter**
  ```sql
CREATE DATABASE currency_converter
    WITH 
    OWNER = networker
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;
```
  - Запуск из командной строки из корневой папки **./mvnw spring-boot:run** (**mvnw spring-boot:run** для Windows)
  - Создание исполняемого jar командой  **./mvnw clean package** (**mvnw clean package** для Windows)
  - Для тестирования приложения воспользоваться формой регистрации для создания нового пользователя
