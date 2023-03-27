/*
 * classes used
 * Admin
 * AdminClientConfig
 * CreateTopicResult
 * NewTopic
 * KafkaFuture
 */
package kafkaapp;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.common.KafkaFuture;

import java.util.*;
public class KafkaTopiCreator {
	
	public KafkaTopiCreator()
	{
		Properties properties=new Properties();
		properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092,localhost:9093");
		Admin admin=Admin.create(properties);
	   String topic="myjavatopic1";
	   int partition=1;
	   short replication_factor=1;
	   NewTopic newtopic=new NewTopic(topic,partition,replication_factor);
	   CreateTopicsResult result=admin.createTopics(Collections.singleton(newtopic));
	   KafkaFuture<Void> future=result.values().get(topic);
	   try {
		     future.get();
		     System.out.println("topic "+topic+" created");
	   }
	   catch(Exception e)
	   {
		   System.out.println(e);
	   }
	}

}
