# gRPC Postfix Calculator

**Input**: expression as array of strings, representing doubles or usual operations (+ - * / ^)

**Ouput**: result as a string representing double (or NaN in case of malformed expression)


Run tests (assuming `scala` and `sbt` installed):
```
sbt test
```

Runs on port 55155:
```
sbt run
```
