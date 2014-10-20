#!/bin/sh
cd "$(dirname "$0")"
java -cp lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:db/mydb --dbname.0 mydb
