import redis.clients.jedis.Jedis;

public class RedisStringJava {
    public static void main(String[] args) {
        // 连接本地的Redis服务
        Jedis jedis = new Jedis("localhost");
        jedis.auth("root");
        System.out.println("连接成功");
        // 设置redis字符串数据
        jedis.set("runoobkey", "www.runoob.com");
        // 获取存储的数据并输出
        System.out.println("redis存储的字符串为：" + jedis.get("runoobkey"));
    }
}
