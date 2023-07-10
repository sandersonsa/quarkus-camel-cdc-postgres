# camel-cdc-postgres

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/camel-cdc-postgres-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- Camel File ([guide](https://access.redhat.com/documentation/en-us/red_hat_integration/2.latest/html/camel_extensions_for_quarkus_reference/extensions-file)): Read and write files
- Camel Language ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/language.html)): Execute scripts in any of the languages supported by Camel
- Camel Core ([guide](https://access.redhat.com/documentation/en-us/red_hat_integration/2.latest/html/camel_extensions_for_quarkus_reference/extensions-core)): Camel core functionality and basic Camel languages: Constant, ExchangeProperty, Header, Ref, Simple and Tokenize
- Camel Direct ([guide](https://access.redhat.com/documentation/en-us/red_hat_integration/2.latest/html/camel_extensions_for_quarkus_reference/extensions-direct)): Call another endpoint from the same Camel Context synchronously
- Camel Jackson ([guide](https://access.redhat.com/documentation/en-us/red_hat_integration/2.latest/html/camel_extensions_for_quarkus_reference/extensions-jackson)): Marshal POJOs to JSON and back using Jackson
- Camel Bean ([guide](https://access.redhat.com/documentation/en-us/red_hat_integration/2.latest/html/camel_extensions_for_quarkus_reference/extensions-bean)): Invoke methods of Java beans
- Camel SQL ([guide](https://access.redhat.com/documentation/en-us/red_hat_integration/2.latest/html/camel_extensions_for_quarkus_reference/extensions-sql)): Perform SQL queries
- Camel Debezium PostgresSQL Connector ([guide](https://camel.apache.org/camel-quarkus/latest/reference/extensions/debezium-postgres.html)): Capture changes from a PostgresSQL database
# quarkus-camel-cdc-postgres


thread #1 - DebeziumConsumer) 1 records sent during previous 00:00:57.163, last recorded offset: {transaction_id=null, lsn_proc=18037008544, lsn_commit=18037008256, lsn=18037008544, txId=14861, ts_usec=1689014146093018}
thread #1 - DebeziumConsumer)

----- ----- ----- ----- ----- ----- -----
thread #1 - DebeziumConsumer) Event received from Debezium : Struct{orderid=3,orderdate=Fri Nov 25 21:00:00 BRT 2022,sku=Apple Magic Keyboard,description=Apple Magic Keyboard for iPad Air 4th Gen,amount=250.56}
thread #1 - DebeziumConsumer)  identificador :: camel-dbz-connector.braindose.orders
thread #1 - DebeziumConsumer)  operation :: c
thread #1 - DebeziumConsumer)  sourceDataSnapshotCompleted :: {schema=braindose, sequence=["18037008256","18037008544"], xmin=null, connector=postgresql, lsn=18037008544, name=camel-dbz-connector, txId=14861, version=1.9.6.Final, ts_ms=1689014146093, snapshot=false, db=dbzdemo, table=orders}
thread #1 - DebeziumConsumer)  base :: dbzdemo
thread #1 - DebeziumConsumer)  tabela :: orders
thread #1 - DebeziumConsumer)  ## Message body: Struct{orderid=3,orderdate=Fri Nov 25 21:00:00 BRT 2022,sku=Apple Magic Keyboard,description=Apple Magic Keyboard for iPad Air 4th Gen,amount=250.56}
thread #1 - DebeziumConsumer)  ## Value :: null
thread #1 - DebeziumConsumer)  ## Value DDL :: null
thread #1 - DebeziumConsumer)  ## Body :: Struct{orderid=3,orderdate=Fri Nov 25 21:00:00 BRT 2022,sku=Apple Magic Keyboard,description=Apple Magic Keyboard for iPad Air 4th Gen,amount=250.56}
thread #1 - DebeziumConsumer)  ## Schema :: Schema{camel_dbz_connector.braindose.orders.Value:STRUCT}
thread #1 - DebeziumConsumer)  ## Schema fields ::
    [
        Field{name=orderid, index=0, schema=Schema{STRING}},
        Field{name=orderdate, index=1, schema=Schema{org.apache.kafka.connect.data.Timestamp:INT64}},
        Field{name=sku, index=2, schema=Schema{STRING}},
        Field{name=description, index=3, schema=Schema{STRING}},
        Field{name=amount, index=4, schema=Schema{FLOAT64}}
    ]
thread #1 - DebeziumConsumer)  ## Schema fields size :: 5
thread #1 - DebeziumConsumer)  ## Campo name :: null
thread #1 - DebeziumConsumer)  # Data :: Fri Nov 25 21:00:00 BRT 2022
thread #1 - DebeziumConsumer)  ## Body Map :: {amount=250.56, orderid=3, description=Apple Magic Keyboard for iPad Air 4th Gen, orderdate=Fri Nov 25 21:00:00 BRT 2022, sku=Apple Magic Keyboard}
