package com.open.designpatterndemo.abstractfactorypattern.impl;

import com.open.designpatterndemo.abstractfactorypattern.Color;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2018 XXX, Inc. All rights reserved. <p>
 * Company: 玖富<p>
 *
 * @author wuchp
 * @since 2018/12/2 12:00
 */
public class Blue implements Color {
    @Override
    public void fill() {
        System.out.println("Inside Blue::fill() method.");
    }
}
