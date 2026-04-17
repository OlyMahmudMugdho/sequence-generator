# Sequence Generator

Simple Java app that generates unique IDs (`ORDER`, `USER`, `INVOICE`) from PostgreSQL sequences.

## Algorithm
1. Lock one sequence row in DB (`SELECT ... FOR UPDATE`).
2. Read current value and add `1`.
3. Save the new value and commit.
4. Return formatted ID like `ORDER-0000000001`.

## Install

Requirements: Java, Maven, Docker (with Compose).

```bash
docker compose -f docker/docker-compose.yaml up -d
docker exec -i postgres psql -U postgres -d sequence_db < db/1_sequence_table.sql
docker exec -i postgres psql -U postgres -d sequence_db < db/2_insert_initial_data.sql
mvn clean install
```

## Run

```bash
./run.sh
```
