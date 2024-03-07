package repo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Pipieline {
    public static void main(String[] args) {
        new Pipieline().run();
    }

    public void run() {
        JedisPool pool = new JedisPool("localhost", 6379);

        try (Jedis jedis = pool.getResource()) {

            Pipeline pipeline = jedis.pipelined();

            pipeline.hset("user#10", "userId", UUID.randomUUID().toString());
            pipeline.hset("user#10", "name", "John");
            pipeline.hget("user#10", "name");

            List<Object> objects = pipeline.syncAndReturnAll();

            System.out.println(jedis.hgetAll("test"));
        }
    }
}