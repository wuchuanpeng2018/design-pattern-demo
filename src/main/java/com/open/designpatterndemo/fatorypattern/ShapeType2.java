package com.open.designpatterndemo.fatorypattern;

import com.open.designpatterndemo.fatorypattern.impl.Circle;
import com.open.designpatterndemo.fatorypattern.impl.Rectangle;
import com.open.designpatterndemo.fatorypattern.impl.Square;

/**
 * 应用模块名称<p>
 * 代码描述<p>
 * Copyright: Copyright (C) 2018 XXX, Inc. All rights reserved. <p>
 * Company: 玖富<p>
 *
 * @author wuchp
 * @since 2018/12/2 0:54
 */
public enum ShapeType2 {
    /** 枚举类型 */
    CIRCLE(new Circle()),
    RECTANGLE(new Rectangle()),
    SQUARE(new Square());

    /** 实现类 */
    private Shape shape;

    /**
     * 获取实现类
     * @param shape
     */
    private ShapeType2(Shape shape) {
        this.shape = shape;
    }

    /**
     * 返回实现类
     * @return
     */
    public Shape getShape() {
        return shape;
    }
}
