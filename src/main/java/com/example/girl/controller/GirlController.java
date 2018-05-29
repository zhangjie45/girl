package com.example.girl.controller;

import com.example.girl.domain.Girl;
import com.example.girl.domain.Result;
import com.example.girl.repository.GirlRepository;
import com.example.girl.service.GirlService;
import com.example.girl.utils.ResultUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GirlController {
    private final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    /*
    查询所有女生列表
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        logger.info("girlList()方法");
        return girlRepository.findAll();
    }

    /*
    添加一个女生
     */
    @PostMapping(value = "/girls")
    public Result<Girl> addGirls(@Valid Girl girl, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResultUtils.error(1, bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setAge(girl.getAge());
        girl.setCpuSize(girl.getCpuSize());
        return ResultUtils.success(girlRepository.save(girl));
    }

    /*
    查询一个女生
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindone(@PathVariable("id") Integer id) {
        return girlRepository.findById(id).get();
    }

    /*
    修改一个女生
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girUpdate(@PathVariable("id") Integer id,
                          @RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCpuSize(cupSize);
        return girlRepository.save(girl);

    }

    /*
    删除一个女生
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.deleteById(id);
    }

    /*
    按照年龄查询女生列表
     */
    @GetMapping(value = "girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    /*
    同时插入两条数据
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
    @GetMapping(value = "/testGitHub")
    public void TestGit(){

    }
}
