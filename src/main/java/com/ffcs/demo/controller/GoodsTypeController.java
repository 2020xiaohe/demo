package com.ffcs.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.ffcs.demo.constant.OperResult;
import com.ffcs.demo.domain.GoodsType;
import com.ffcs.demo.service.GoodsTypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by hemb on 2020/8/5.
 */
@CrossOrigin
@RestController
@RequestMapping("api/goodsType")
public class GoodsTypeController {

    private Logger logger = LoggerFactory.getLogger(GoodsTypeController.class);
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 添加商品种类
     * @param goodsType 商品种类信息
     * @return
     */
    @GetMapping("/addGoodsType")
    public String addGoodsType(GoodsType goodsType,HttpSession session){
        JSONObject json= new JSONObject();
        // 获取登录用户信息
        goodsType.setOperId((Integer) session.getAttribute("userId"));
        goodsType.setOperDate(new Date());
        goodsTypeService.getGoodsTypeDao().save(goodsType);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_SAVE_SUCCESS);
        return  json.toString();
    }

    /**
     * 删除商品种类
     * @param id 商品种类id
     * @return
     */
    @GetMapping("/delGoodsType")
    public String delGoodsType(Integer id, HttpSession session){
        JSONObject json= new JSONObject();
        goodsTypeService.getGoodsTypeDao().deleteById(id);
        logger.info(session.getAttribute("userId")+"删除了id为"+id+"的商品种类");
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_DELETE_SUCCESS);
        return  json.toString();
    }

    /**
     * 修改商品种类信息
     * @param goodsType 变更后的商品种类信息
     * @return
     */
    @GetMapping("/updateGoodsType")
    public String updateGoodsType(GoodsType goodsType){
        JSONObject json= new JSONObject();
        goodsTypeService.getGoodsTypeDao().updataGoodsType(goodsType);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_UPDATE_SUCCESS);
        return  json.toString();
    }


    /**
     * 查询所有商品种类
     * @return
     */
    @GetMapping("/getAllGoodsInfo")
    public String  getAll(){
        JSONObject json= new JSONObject();
        json.put("goodsType",goodsTypeService.getGoodsTypeDao().findAll());
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return  json.toString();
    }

    @GetMapping("/getAllGoodsTypePage")
    public String  getAllGoodsTypePage(int pageNum, int pageSize){
        JSONObject json= new JSONObject();
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<GoodsType> pageInfo = new PageInfo<>(goodsTypeService.getGoodsTypeDao().findAll());
        json.put("goodsType",pageInfo);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return  json.toString();
    }

}
