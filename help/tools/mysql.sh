# Login
mysql -u usosweb -p -h localhost

# Wgranie bazy danych
mysql -u root < ofiko.database.sql

# Nazwiazanie połączenia.
mysql -u yourusername -p yourpassword yourdatabase

# Wykonanie skryptu sql.
mysql -u yourusername -p yourpassword yourdatabase < text_file

# Wykonanie skryptu z pliku.
mysql --user="username" --database="databasename" --password="yourpassword" < "filepath"
