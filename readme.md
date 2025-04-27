RUN:
- `cd lab-2`
- `docker compose up -d`
- `cd ../`
- `vagrant up`

Connect to DB:
`psql -h localhost -p 6432 -U testuser -d testdb -W`
