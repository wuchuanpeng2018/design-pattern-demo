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
 * @since 2018/12/1 23:06
 */
public enum ShapeType {

    /** 对应的枚举类和姓名关系 */
    CIRCLE(new Circle(),"CIRCLE"),
    RECTANGLE(new Rectangle(),"RECTANGLE"),
    SQUARE(new Square(),"SQUARE");

    /** 成员变量:实体类 */
    private Shape shape;
    /** 成员变量:姓名 */
    private String name;

    /**
     * 普通方法:获取枚举对应的实体类
      * @param name
     * @return
     */
    public static Shape getShape(String name) {
        for ( ShapeType c : ShapeType.values()) {
            if (c.name == name) {
                return c.shape;
            }
        }
        return null;
    }

    /**
     * 构造方法
     * @param shape
     * @param name
     */
    private ShapeType(Shape shape, String name) {
        this.shape = shape;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public Shape getShape() {
        return shape;
    }
    public void setShape(Shape shape) {
        this.shape = shape;
    }
    public void setName(String name) {
        this.name = name;
    }
}
