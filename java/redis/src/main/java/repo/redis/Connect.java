package repo.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;
import java.util.Map;

public class Connect {
    public static void main(String[] args) {
        new Connect().run();
    }

    public void run() {
        JedisPool pool = new JedisPool("localhost", 6379);

        try (Jedis jedis = pool.getResource()) {
            // Store & Retrieve a simple string
            jedis.set("foo", "bar");
            // jedis.pipelined()
            System.out.println(jedis.get("foo")); // prints bar

            // Store & Retrieve a HashMap
            Map<String, String> map = new HashMap<>();
            map.put("name", "John");
            map.put("surname", "Smith");
            map.put("company", "Redis");
            map.put("age", "29");

            jedis.hset("user-session#123", map);

            System.out.println(jedis.hgetAll("user-session:123"));

            // Prints: {name=John, surname=Smith, company=Redis, age=29}
        }
    }
}