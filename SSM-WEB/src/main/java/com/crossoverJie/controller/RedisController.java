package com.crossoverJie.controller;

import com.crossoverJie.dao.PriceMapper;
import com.crossoverJie.dao.RediscontentMapper;
import com.crossoverJie.enums.StatusEnum;
import com.crossoverJie.pojo.RedisContent;
import com.crossoverJie.req.RedisContentReq;
import com.crossoverJie.request.anotation.CheckReqNo;
import com.crossoverJie.res.BaseResponse;
import com.crossoverJie.service.RediscontentService;
import com.crossoverJie.util.CommonUtil;
import com.crossoverJie.util.PageEntity;
import com.crossoverJie.util.ThreadPoolConfig;
import com.crossoverJie.vo.NULLBody;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/redis")
public class RedisController {

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RediscontentService rediscontentService;

    @Autowired
    private PriceMapper priceMapper ;

    @Autowired
    private RediscontentMapper rediscontentMapper;

    @Autowired
    private ThreadPoolConfig config ;

    @RequestMapping("/redis_list")
    public void club_list(HttpServletResponse response,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "pageSize", defaultValue = "0") int pageSize) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jo = new JSONObject();
        try {
            JSONArray ja = new JSONArray();
            PageHelper.startPage(1, 10);
            PageEntity<RedisContent> rediscontentPageEntity = rediscontentService.selectByPage(page, pageSize);
            for (RedisContent redisContent : rediscontentPageEntity.getList()) {
                JSONObject jo1 = new JSONObject();
                jo1.put("redisContent", redisContent);
                ja.add(jo1);
            }
            jo.put("redisContents", ja);
            jo.put("count", rediscontentPageEntity.getCount());
            jsonObject = CommonUtil.parseJson("1", "成功", jo);

        } catch (Exception e) {
            jsonObject = CommonUtil.parseJson("2", "操作异常", "");
            logger.error(e.getMessage(), e);
        }
        //构建返回
        CommonUtil.responseBuildJson(response, jsonObject);
    }

    @CheckReqNo
    @RequestMapping(value = "/createRedisContent",method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse<NULLBody> createRedisContent(@RequestBody RedisContentReq redisContentReq){
        BaseResponse<NULLBody> response = new BaseResponse<NULLBody>() ;

        RedisContent redisContent = new RedisContent() ;
        try {
            CommonUtil.setLogValueModelToModel(redisContentReq, redisContent);
            rediscontentMapper.insertSelective(redisContent) ;
            response.setReqNo(redisContentReq.getReqNo());
            response.setCode(StatusEnum.SUCCESS.getCode());
            response.setMessage(StatusEnum.SUCCESS.getMessage());
        }catch (Exception e){
            logger.error("system error",e);
            response.setReqNo(response.getReqNo());
            response.setCode(StatusEnum.FAIL.getCode());
            response.setMessage(StatusEnum.FAIL.getMessage());
        }

        return response ;

    }




}
