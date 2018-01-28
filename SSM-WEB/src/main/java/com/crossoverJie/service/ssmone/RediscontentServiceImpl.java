package com.crossoverJie.service.ssmone;

import com.crossoverJie.dao.RediscontentMapper;
import com.crossoverJie.pojo.RedisContent;
import com.crossoverJie.pojo.RedisContentExample;
import com.crossoverJie.service.RediscontentService;
import com.crossoverJie.util.PageEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2016/12/9 上午12:17
 * @since JDK 1.7
 */
@Service
public class RediscontentServiceImpl implements RediscontentService {

    @Autowired
    private RediscontentMapper rediscontentMapper;


    @Override
    public List<RedisContent> selectByExample(RedisContentExample example) {
        return rediscontentMapper.selectByExample(example);
    }

    @Override
    public RedisContent selectByPrimaryKey(Integer id) {
        return rediscontentMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageEntity<RedisContent> selectByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        //因为是demo，所以这里默认没有查询条件。
        List<RedisContent> redisContents = rediscontentMapper.selectByExample(new RedisContentExample());
        PageEntity<RedisContent> rediscontentPageEntity = new PageEntity<RedisContent>();
        rediscontentPageEntity.setList(redisContents);
        int size = rediscontentMapper.selectByExample(new RedisContentExample()).size();
        rediscontentPageEntity.setCount(size);
        return rediscontentPageEntity;
    }


}
