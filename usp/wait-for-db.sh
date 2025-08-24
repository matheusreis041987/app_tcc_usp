#!/bin/sh
# wait-for-db.sh

set -e

host="$1"
user="$2"
db="$3"
shift 3
cmd="$@"

>&2 echo "Waiting for database to be available at $host"

until PGPASSWORD=secret psql -h "$host" -U "$user" -d "$db" -c '\q'; do
  >&2 echo "Postgres is unavailable - sleeping"
  sleep 1
done

>&2 echo "Postgres is up - executing command"
exec $cmd