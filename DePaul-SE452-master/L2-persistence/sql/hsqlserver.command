#!/bin/sh
cd "$(dirname "$0")"
java -cp lib/hsqldb.jar org.hsqldb.Server -database.0 file:mydb -dbname.0 mydb
