# Конвертер валют

### Задача:

Сделать конвертер валют

### Описание:

При запуске приложения, необходимо получить список актуальных валют и их курсов с сайта ЦБРФ http://www.cbr.ru/scripts/XML_daily.asp (дополнительная информация https://cbr.ru/development/sxml/) и записать их в базу данных (индентификаторы, коды, названия), а так же курсы (привязанные к валюте) на дату запроса. В конвертере должна быть авторизация по логину и паролю. Пользователь пройдя авторизацию попадает на главный экран, где может выбрать из какой валюты и в какую будет конвертация, указывает количество переводимых средств и нажимает кнопку "Конвертировать". После чего происходит запрос в БД на получение актуального курса на ***текущую дату***, если данные на текущую дату отсутствуют, необходимо, произвести получение курсов с сайта ЦБ и добавить новые записи в базу данных. Также в конвертере должна вестись история произведенных конвертаций с записью в базу данных со ссылкой на курс по которой была произведена конвертаци. Историю можно посмотреть на той же странице конвертера или отдельной вкладке (возможна реализация базовых фильтров). Остальная функциональность и визуал по желанию.

#### Используемые технологии:
 - Java 11
 - Maven
 - Spring Boot 2.2.4
 - Spring Security
 - Thymeleaf
 - PostgreSQL 12
 - HTML5/CSS(Bootstrap)

 #### Рекомендации для сборки и запуска проекта:
  - Создать на сервере БД пользователия **networker** с паролем **sQzMaXd?PMqp8bZwafea**
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
  - Создание исполняемого **jar** командой  **./mvnw clean package** (**mvnw clean package** для Windows)
  - Запуск **jar** файла из командной строки:     перейти в папку с **jar** файлом и воспользоваться командой **java -jar currency-converter-0.0.1-SNAPSHOT.jar**
  - Для тестирования приложения воспользоваться формой регистрации для создания нового пользователя
  
  ### Проект развернут на <a href="https://azure.microsoft.com/" target="_blank" rel="nofollow noopener"><img src="https://upload.wikimedia.org/wikipedia/commons/thumb/a/a8/Microsoft_Azure_Logo.svg/187px-Microsoft_Azure_Logo.svg.png" width="64"></a> и доступен по ссылке:    
  http://currency-converter.nikolaev.pro
