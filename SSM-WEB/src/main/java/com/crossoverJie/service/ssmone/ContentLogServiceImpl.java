package com.crossoverJie.service.ssmone;

import com.crossoverJie.dao.ContentLogMapper;
import com.crossoverJie.pojo.ContentLog;
import com.crossoverJie.service.ContentLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/1/16 上午12:12
 * @since JDK 1.7
 */
@Service
public class ContentLogServiceImpl implements ContentLogService {

    @Autowired
    private ContentLogMapper contentLogMapper;

    @Override
    public int insertSelective(ContentLog record) {

        return contentLogMapper.insertSelective(record);
    }
}
