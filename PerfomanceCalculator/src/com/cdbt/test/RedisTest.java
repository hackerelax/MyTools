package com.cdbt.test;

import redis.clients.jedis.Jedis;

public class RedisTest {

	private static Jedis jedis;

	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		try {
			jedis = new Jedis("localhost");
			System.out.println("正在连接");
			// 设置 redis 字符串数据
			jedis.set("runoobkey", "www.runoob.com");
			// 获取存储的数据并输出
			System.out.println("redis 存储的字符串为: " + jedis.get("runoobkey"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("连接失败");
		}
		jedis.close();
	}
}
