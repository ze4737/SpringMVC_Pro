package com.springmvc.util;

import junit.framework.TestCase;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by ZE on 1/9.
 * �����ù����ࣺ
 * ����ApplicationContext�Ϳ��Ի��Spring����
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class BaseSpringTestCase extends TestCase {

}
