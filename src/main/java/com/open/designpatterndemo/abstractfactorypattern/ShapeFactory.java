package com.open.designpatterndemo.abstractfactorypattern;

import com.open.designpatterndemo.fatorypattern.Shape;
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
 * @since 2018/12/2 12:04
 */
public class ShapeFactory  extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }
}
