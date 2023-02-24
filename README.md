1. Running DB 
   >  docker run  --name postgres_13 -p 5432:5432 -e POSTGRES_DB=demo -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -d postgres:13

2. In order to avoid blocking requests, the race condition is not resolved