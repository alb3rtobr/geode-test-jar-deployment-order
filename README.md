# geode-test-jar-deployment-order

Reported problem: JAR deployment order causes a failure when region is created. The region uses a CacheListener deployed on one JAR which depends on a 3pp JAR. If 3PP jar is deployed before the CacheListener JAR, there is no error. But if CacheListener is deployed before 3PP JAR, there is a LinkageError

1. Generate DummyCacheListener
```
$ cd DummyCacheListener
$ mvn install
```

2. Start locator, server and deploy jars
```
$ gfsh < start.gfsh
```

It should fail...
