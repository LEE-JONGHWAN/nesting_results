package com.ezen.mybatis.channel;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ChannelMain {
	public static void main(String[] args) {
		try  {
			ChannelMain main = new ChannelMain();
			List<ShowChannel> channels = main.getChannelAndViewers();
			
			channels.forEach(c -> {
				System.out.println("주제: " + c.get주제());
				System.out.println("진행자: " + c.get진행자());
				System.out.println("애청자: ");
				c.getViewers().forEach(v -> {
					System.out.print("\t" + v.toString() + " ");
				});
			});
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static SqlSession getSqlSession() throws Exception {
		String resource = "core-channel-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = 
			new SqlSessionFactoryBuilder().build(inputStream);
		
		return sqlSessionFactory.openSession();
	}

	private List<ShowChannel> getChannelAndViewers() throws Exception {
		return getSqlSession().selectList("getChannelAndViewers");
	}
}
