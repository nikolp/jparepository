Example of easily switching between two providers,
while keeping the same repository.

# Demo steps
```
mvn clean package
```

## H2: easier, the default

```
java -jar target/jparepository-0.0.1-SNAPSHOT.jar
```

And log into h2 console to see the database

## MySQL
Must first install it locally, create the db, user, password
(Could not get the connecting to work when using docker version)

```
java -jar -Dspring.profiles.active=mysql target/jparepository-0.0.1-SNAPSHOT.jar 
```
Check the results
```
mysql -uexample_user -pexample_password
use example_db;
select * from mdfile;
```

## Postgres
To avoid too much junk, did not set it up as a service that auto-starts.
So run it as follows:
```
postgres -D /opt/homebrew/var/postgresql@13
```
Then additional setup
```
psql postgres
CREATE DATABASE sampledb;
\c sampledb
\c postgres
CREATE USER sample_user WITH PASSWORD 'sample_password';
```
Then 
```
java -jar -Dspring.profiles.active=pgres target/jparepository-0.0.1-SNAPSHOT.jar 
```
Then check
```
psql --dbname=sampledb --username=sample_user --password
select * from mdfile;
\d mdfile
```

Notice the command below where db engine was initialized. If you 
```cat /opt/homebrew/var/postgresql@13/pg_hba.conf```
you will see that all users can log in if they are coming in locally.


```
brew install postgresql@13

This formula has created a default database cluster with:
  initdb --locale=C -E UTF-8 /opt/homebrew/var/postgresql@13
For more details, read:
  https://www.postgresql.org/docs/13/app-initdb.html

postgresql@13 is keg-only, which means it was not symlinked into /opt/homebrew,
because this is an alternate version of another formula.

If you need to have postgresql@13 first in your PATH, run:
  echo 'export PATH="/opt/homebrew/opt/postgresql@13/bin:$PATH"' >> ~/.zshrc

For compilers to find postgresql@13 you may need to set:
  export LDFLAGS="-L/opt/homebrew/opt/postgresql@13/lib"
  export CPPFLAGS="-I/opt/homebrew/opt/postgresql@13/include"

To start postgresql@13 now and restart at login:
  brew services start postgresql@13
Or, if you don't want/need a background service you can just run:
  /opt/homebrew/opt/postgresql@13/bin/postgres -D /opt/homebrew/var/postgresql@13
```