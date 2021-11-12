package org.bbs.dbconn;

import org.bbs.mapper.TestMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
// junit4�� ����� �׽�Ʈ�� �ϰڴٴ� ��
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
// (���� ���� ����ֱ�) Bean ��ġ ����ֱ�
@Log4j
// log ���� ���� ����
public class MyBatisSQLTest {
	
	// test 

	@Autowired
	// Bean���� ���� ��ü�� �ִٸ� �ڵ����� ���� ������ �޶�
	private TestMapper testMapper;
	
	
	@Test
	public void testSelect() {
		
		String nowTime = testMapper.getTime();
		log.info("========== MyBatis testSelect ==========");
		log.info("���� �ð� >>>>>> " + nowTime);
	}
		
}
