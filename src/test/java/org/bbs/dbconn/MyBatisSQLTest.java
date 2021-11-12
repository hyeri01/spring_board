package org.bbs.dbconn;

import org.bbs.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
// junit4를 사용해 테스트를 하겠다는 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// (설정 파일 잡아주기) Bean 위치 잡아주기
@Log4j
// log 찍어내기 위한 설정
public class MyBatisSQLTest {
	
	// test 

	@Autowired
	// Bean으로 잡힌 객체가 있다면 자동으로 의존 주입해 달라
	private TestMapper testMapper;
	
	
	@Test
	public void testSelect() {
		
		String nowTime = testMapper.getTime();
		log.info("========== MyBatis testSelect ==========");
		log.info("현재 시간 >>>>>> " + nowTime);
	}
		
}
