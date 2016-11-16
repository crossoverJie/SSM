package com.crossoverjie;


import com.crossoverJie.service.ContentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class RedisTest {

    @Autowired
    private ContentService contentService;


    @Test
    public void redisTest() {
//		List<Content> list1 = contentService.findContentList() ;
//		List<Content> list2 = contentService.findContentList();
//		boolean flag= (list1 == list2);
//		System.out.println(list1);
    }


}
