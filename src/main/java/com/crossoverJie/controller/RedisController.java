package com.crossoverJie.controller;

import com.crossoverJie.pojo.Rediscontent;
import com.crossoverJie.service.RediscontentService;
import com.crossoverJie.util.CommonUtil;
import com.crossoverJie.util.PageEntity;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/redis")
public class RedisController {

    private static Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    private RediscontentService rediscontentService;


    @RequestMapping("/redis_list")
    public void club_list(HttpServletResponse response,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "pageSize", defaultValue = "0") int pageSize) {
        JSONObject jsonObject = new JSONObject();
        JSONObject jo = new JSONObject();
        try {
            JSONArray ja = new JSONArray();
            PageHelper.startPage(1, 10);
            PageEntity<Rediscontent> rediscontentPageEntity = rediscontentService.selectByPage(page, pageSize);
            for (Rediscontent rediscontent : rediscontentPageEntity.getList()) {
                JSONObject jo1 = new JSONObject();
                jo1.put("rediscontent", rediscontent);
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

}
