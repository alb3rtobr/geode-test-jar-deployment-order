
package io.github.alb3rtobr.test;

import org.apache.geode.cache.*;
import org.apache.geode.cache.util.*;
import org.apache.kafka.common.KafkaException;

import org.apache.geode.logging.internal.log4j.api.LogService;
import org.apache.logging.log4j.Logger;

public class MyCacheListener extends CacheListenerAdapter<String,String>{

    private final static Logger logger = LogService.getLogger();

    @Override
    public void afterRegionCreate(RegionEvent event) {
        new KafkaException();
        logger.info("MyCacheListener::afterRegionCreate");
    }

    @Override
    public void afterInvalidate(EntryEvent<String, String> event)
    {
        new KafkaException();
        logger.info("MyCacheListener::afterInvalidate");
    }
}
