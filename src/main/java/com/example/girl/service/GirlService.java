package com.example.girl.service;

import com.example.girl.domain.Girl;
import com.example.girl.enums.ResultEnum;
import com.example.girl.exception.GirlException;
import com.example.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {
    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
//        Girl girlA = new Girl();
//        girlA.setId(11);
//        girlA.setCpuSize("A");
//        girlA.setAge(18);
//        girlRepository.save(girlA);
//
//        Girl girlB = new Girl();
//        girlB.setId(12);
//        girlB.setCpuSize("B");
//        girlB.setAge(18);
//        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if (age < 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
            //返回你应该在上小学
        } else if (age > 10 && age < 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
            //返回你可能在上初中
        }
    }
}
