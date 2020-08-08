Сервис по выгрузке файлов из произвольного каталога.
У всех пользователей по умолчанию доступ к .txt файлам, у авторизованных - ко всем другим.
Есть админка для настройки ролей пользователей.

![Image alt](https://github.com/VadimRybakov/SpringFileDownloader/raw/master/screenshots/authorization.png)
![Image alt](https://github.com/VadimRybakov/SpringFileDownloader/raw/master/screenshots/main.png)
![Image alt](https://github.com/VadimRybakov/SpringFileDownloader/raw/master/screenshots/users.png)

1.Настройка базы данных PostgreSQL:

Создаем базу данных test DROP DATABASE IF EXISTS test; CREATE DATABASE test;

Подключаемся к test, создаем схему currency \c test; DROP SCHEMA IF EXISTS currency; CREATE SCHEMA currency;

Создаем пользователя и настраиваем ему права доступа к базе данных test CREATE ROLE manager WITH PASSWORD 'manager' LOGIN; GRANT ALL ON SCHEMA currency TO manager;

2.Сборка проекта:

откройте командную строку, перейдите в директорию с проектом, далее выполните последовательно команды: mvn package, mvn install. В директории target открываем файл FileManager-0.0.1-SNAPSHOT.jar, приложение запускается на порту 8189, url = "http://localhost:8189/files/".
Логины пользователей admin, user пароли admin, user, соответственно.
