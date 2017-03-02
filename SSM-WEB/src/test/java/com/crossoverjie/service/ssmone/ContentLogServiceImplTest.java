package com.crossoverjie.service.ssmone;

import com.crossoverJie.pojo.Content;
import com.crossoverJie.pojo.ContentLog;
import com.crossoverJie.service.ContentLogService;
import com.crossoverJie.service.ContentService;
import com.crossoverJie.util.CommonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/1/16 上午12:14
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class ContentLogServiceImplTest {

    @Autowired
    private ContentLogService contentLogService;

    @Autowired
    private ContentService contentService;

    @Test
    public void insertSelective() throws Exception {

        Content content = new Content();
        content.setContent("asdsf");
        content.setCreatedate("2016-12-09");
        contentService.insertSelective(content);

        ContentLog log = new ContentLog();
        log.setContentid(content.getContentid());
        log.setContent("asdsf");
        log.setCreatedate("2016-12-09");
        contentLogService.insertSelective(log);
    }

    @Test
    public void insertSelective2() throws Exception {
        Content content = new Content();
        content.setContent("你好");
        content.setContentname("1");
        content.setCreatedate("2016-09-23");

        contentService.insertSelective(content);

        ContentLog log = new ContentLog();
        CommonUtil.setLogValueModelToModel(content, log);
        contentLogService.insertSelective(log);
    }


}