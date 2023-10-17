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
Kill the above or run in another terminal
```
mysql -uexample_user -pexample_password
use example_db;
select * from mdfile;
```

