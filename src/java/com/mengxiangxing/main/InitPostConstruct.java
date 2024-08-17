package com.mengxiangxing.main;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

public class InitPostConstruct implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet()");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct");
    }

    private void initMethod() {
        System.out.println("initMethod()");
    }

}
