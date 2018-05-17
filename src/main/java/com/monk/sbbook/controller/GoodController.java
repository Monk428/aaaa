package com.monk.sbbook.controller;

import com.monk.sbbook.entity.GoodInfoEntity;
import com.monk.sbbook.result.pojo.JsonResult;
import com.monk.sbbook.result.pojo.Result;
import com.monk.sbbook.service.impl.GoodInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import java.util.List;

/**
 * ========================
 *
 * @author 恒宇少年
 * Created with IntelliJ IDEA.
 * Date：2017/11/5
 * Time：15:02
 * 码云：http://git.oschina.net/jnyqy
 * ========================
 */
@RestController
@RequestMapping(value = "/good")
public class GoodController
{
    /**
     * 商品业务逻辑实现
     */
    @Autowired
    private GoodInfoService goodInfoService;
    /**
     * 添加商品
     * @return
     */
    @RequestMapping(value = "/save")
    public Long save(GoodInfoEntity good) throws Exception
    {
        return goodInfoService.saveGood(good);
    }

    @RequestMapping(value = "/findAll")
    public Result findAll()
    {
        List list = goodInfoService.queryAllGood();

        return JsonResult.genSuccessResult(list);
    }
}
