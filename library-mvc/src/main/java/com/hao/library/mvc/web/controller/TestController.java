package com.hao.library.mvc.web.controller;

import cn.hutool.core.util.RandomUtil;
import com.hao.base.common.bean.Res;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("test")
    public Res<Integer> test() {
        int n = RandomUtil.randomInt();
        return Res.success(n);
    }

}
