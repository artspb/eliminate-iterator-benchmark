# eliminate-iterator-benchmark

```
mvn clean package
java -jar target/benchmarks.jar -jvmArgsAppend '-XX:+UseConcMarkSweepGC -XX:+DoEscapeAnalysis' 'me.artspb.java.benchmark.smartlist.SmartListSizeBenchmark'
```
