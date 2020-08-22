package com.ffcs.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ffcs.demo.constant.OperResult;
import com.ffcs.demo.domain.GoodsInfo;
import com.ffcs.demo.entity.Goods;
import com.ffcs.demo.service.GoodsInfoService;
import com.ffcs.demo.utils.PicUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 商品后台的增删改查管理
 * Created by hemb on 2020/8/4.
 */
@CrossOrigin
@RestController
@RequestMapping("api/goodsInfo")
public class GoodsInfoController {
    private Logger logger = LoggerFactory.getLogger(GoodsInfoController.class);

    @Autowired
    private GoodsInfoService goodsInfoService;

    /**
     * 根据文件名获取图片
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/getPic",produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage(String picPath) throws IOException {
        File file = new File(picPath);
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());
        return bytes;
    }

    /**
     * 商品管理---添加商品
     * @param pic  图片
     * @param goodsInfo  商品详情
     * @return  保存成功/保存失败
     */
    @PostMapping("/addGoodsInfo")
    public String addGoodsInfo(MultipartFile pic, GoodsInfo goodsInfo, HttpSession session) {
        JSONObject json= new JSONObject();
        String result = "";
        try {
            result = PicUtils.singleFileUpload(pic);
            goodsInfo.setPicPath(result);
            goodsInfo.setOperId((Integer) session.getAttribute("userId"));
            goodsInfo.setStatus(1);
            goodsInfo.setOperDate(new Date());
            goodsInfoService.getGoodsInfoDao().save(goodsInfo);
            result = OperResult.OPERATION_RESULT_SAVE_SUCCESS;
        } catch (Exception e) {
            result = OperResult.OPERATION_RESULT_SAVE_FAIL;
            logger.error(e.toString());
        }
        json.put(OperResult.OPERATION_RESULT_KEY,result);
        return json.toString();
    }

    /**
     * 商品管理---商品状态管理
     * @param id  商品id
     * @param goodsStatus  商品状态修改为 1---正常 2---缺货 3---下架
     * @return
     */
    @GetMapping("/operGoodsInfoStatus")
    public String operGoodsInfoStatus(Integer id, Integer goodsStatus,HttpSession session){
        JSONObject json= new JSONObject();
        GoodsInfo goodsInfo = goodsInfoService.getGoodsInfoDao().getOne(id);
        goodsInfo.setStatus(goodsStatus);
        goodsInfo.setOperId((Integer) session.getAttribute("userId"));
        goodsInfoService.getGoodsInfoDao().save(goodsInfo);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_UPDATE_SUCCESS);
        return  json.toString();
    }

    /**
     * 商品管理---商品信息修改
     * @param goodsInfo
     * @return
     */
    @PostMapping("/updateGoodsInfo")
    public String updateGoodsInfo(GoodsInfo goodsInfo){
        JSONObject json= new JSONObject();
        goodsInfoService.getGoodsInfoDao().updateGoodsInfo(goodsInfo);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_UPDATE_SUCCESS);
        return  json.toString();
    }

    /**
     * 商品管理---获取所有商品
     * @return
     */
    @GetMapping("/getAllGoodsInfo")
    public String  getAllGoodsInfo(int pageNum, int pageSize){
        JSONObject json= new JSONObject();
//        List<GoodsInfo> goodsInfos = goodsInfoService.getGoodsInfoDao().findAll();
        PagingAndSortingRepository<GoodsInfo, Integer> repository = goodsInfoService.getGoodsInfoDao();
//        Sort sort = Sort.by(Sort.Direction.DESC,"operDate");
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<GoodsInfo> pageInfo  = repository.findAll(pageable);
        for (GoodsInfo g: pageInfo.getContent() ) {
            if (g.getStatus() == 1){
                g.setStatusDesc("正常");
            }else if (g.getStatus() == 2){
                g.setStatusDesc("缺货");
            }else {
                g.setStatusDesc("下架");
            }
        }
        json.put("goodsInfo",pageInfo);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return JSON.toJSONString(json, SerializerFeature.DisableCircularReferenceDetect);
    }

    /**
     * 商品管理---获取所有商品--分页
     * zhuwb 20200808
     * @return
     */
    @GetMapping("/getPageAllGoodsInfo")
    public String  getPageAllGoods(int pageNum, int pageSize){
        JSONObject json= new JSONObject();
        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Goods> pageInfo = new PageInfo<>(goodsInfoService.getPageALL());
        for (Goods g : pageInfo.getList() ) {
            if (g.getStatus() == 1){
                g.setStatusDesc("正常");
            }else if (g.getStatus() == 2){
                g.setStatusDesc("缺货");
            }else {
                g.setStatusDesc("下架");
            }
        }
        json.put("goodsInfo",pageInfo);
        json.put(OperResult.OPERATION_RESULT_KEY,OperResult.OPERATION_RESULT_SEARCH_SUCCESS);
        return  json.toString();
    }
}
