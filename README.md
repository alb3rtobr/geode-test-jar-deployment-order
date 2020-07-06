# geode-test-jar-deployment-order

Reported problem:
* JAR deployment order causes a failure when region is created.
* The region uses a CacheListener deployed on one jar which depends on a 3pp jar.
* If 3PP jar is deployed before the CacheListener jar, there is no error.
* If CacheListener jar is deployed before 3PP jar, there is a LinkageError

1. Generate DummyCacheListener
```
$ cd DummyCacheListener
$ mvn install
```

2. Start locator, server and deploy jars (`start.gfsh` deploys `DummyCacheListener.jar` before `kafka-client.jar` to force the error)
```
$ gfsh < start.gfsh
```

It should fail, but it currently works for me:

```
gfsh>create region --name=/test-region --type=LOCAL --cache-listener=io.github.alb3rtobr.test.MyCacheListener
Member  | Status | Message
------- | ------ | ------------------------------------------
server1 | OK     | Region "/test-region" created on "server1"

Cluster configuration for group 'cluster' is updated.

```

Just changing my DummyCacheListener by the faulty CacheListener:

```
gfsh>create region --name=/test-region --type=LOCAL --cache-listener=<the faulty cacheListener>
Member | Status | Message
------ | ------ | -------
```

And LinkageErrors can be found in server1 log.

