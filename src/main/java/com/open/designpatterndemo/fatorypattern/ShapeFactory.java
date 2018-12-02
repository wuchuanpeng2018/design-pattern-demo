package com.open.designpatterndemo.fatorypattern;

import com.open.designpatterndemo.fatorypattern.impl.Circle;
import com.open.designpatterndemo.fatorypattern.impl.Rectangle;
import com.open.designpatterndemo.fatorypattern.impl.Square;

/**
 * 应用模块名称<p>
 * 工厂模式
 * Copyright: Copyright (C) 2018 XXX, Inc. All rights reserved. <p>
 * Company: 玖富<p>
 *  一句话概括工厂模式
 *  简单工厂：一个工厂类，一个产品抽象类。
 *  工厂方法：多个工厂类，一个产品抽象类。
 *  抽象工厂：多个工厂类，多个产品抽象类。
 *  二、生活中的工厂模式
 *
 *  简单工厂类：一个麦当劳店，可以生产多种汉堡。
 *  工厂方法类：一个麦当劳店，可以生产多种汉堡。一个肯德基店，也可以生产多种汉堡。
 *  抽象工厂类：百胜餐饮集团下有肯德基和百事公司，肯德基生产汉堡，百事公司生成百事可乐。
 *  其实使用反射是一种不错的办法，但反射也是从类名反射而不能从类反射！
 *
 * 先看一下工厂模式是用来干什么的——属于创建模式，解决子类创建问题的。换句话来说，
 * 调用者并不知道运行时真正的类名，只知道从“Circle"可以创建出一个shape接口的类，
 * 至于类的名称是否叫'Circle"，调用者并不知情。所以真正的对工厂进行扩展的方式
 * （防止程序员调用出错）可以考虑使用一个枚举类（防止传入参数时，把circle拼写错误）。
 *
 * 如果调用者参肯定类型是Circle的话，那么其工厂没有存在的意义了！
 * 比如 IShape shape = new Circle();这样不是更好？
 * 也就是说调用者有了Circle这个知识是可以直接调用的，
 * 根据DP（迪米特法则）其实调用者并不知道有一个Circle类的存在，
 * 他只需要知道这个IShape接口可以计算圆面积，而不需要知道；
 * 圆这个类到底是什么类名——他只知道给定一个”circle"字符串的参数,
 * IShape接口可以自动计算圆的面积就可以了！
 * 其实在.net类库中存在这个模式的的一个典型的。但他引入的另一个概念“可插入编程协议”。
 * 那个就是WebRequest req = WebRequest.Create("http://ccc......");
 * 可以自动创建一个HttpWebRequest的对象，当然，如果你给定的是一个ftp地址，
 * 他会自动创建一个FtpWebRequest对象。
 * 工厂模式中着重介绍的是这种通过某个特定的参数，让你一个接口去干对应不同的事而已！
 * 而不是调用者知道了类！
 * 比如如果圆的那个类名叫"CircleShape“呢？不管是反射还是泛型都干扰了你们具体类的生成！
 * 其实这个要说明的问题就是这个，调用者（clinet)只知道IShape的存在，
 * 在创建时给IShape一个参数"Circle",它可以计算圆的面积之类的工作，但是为什么会执行这些工作，
 * 根据迪米特法则，client是不用知道的。
 * 我想问一下那些写笔记的哥们，如果你们知道了泛型，那么为什么不直接使用呢？
 * 干吗还需要经过工厂这个类呢？不觉得多余了吗？
 * 如果，我只是说如果，如果所有从IShape继承的类都是Internal类型的呢？
 * 而client肯定不会与IShape一个空间！这时，你会了现你根本无法拿到这个类名！
 * Create时使用注册机制是一种简单的办法，比如使用一个枚举类，把功能总结到一处。
 * 而反射也是一种最简单的办法，调用者输入的名称恰是类名称或某种规则时使用，
 * 比如调用者输入的是Circle，而类恰是CircleShape，那么可以通过输入+
 * ”Shape"字符串形成新的类名，然后从字符串将运行类反射出来！
 * 工厂的创建行为，就这些作用，还被你们用反射或泛型转嫁给了调用者（clinet)，
 * 那么，这种情况下，要工厂类何用？！
 * @author wuchp
 * @since 2018/12/1 23:00
 */
public class ShapeFactory {

    /**
     * 使用 getShape 方法获取形状类型的对象
     * @param shapeType
     * @return
     */
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        /**
         * 方式1
         */
//        if("CIRCLE".equalsIgnoreCase(shapeType)){
//            return new Circle();
//        } else if("RECTANGLE".equalsIgnoreCase(shapeType)){
//            return new Rectangle();
//        } else if("SQUARE".equalsIgnoreCase(shapeType)){
//            return new Square();
//        }

        /**
         * 方法2：使用枚举类
         */
        ShapeType.getShape(shapeType).draw();
        ShapeType.getShape("RECTANGLE").draw();
        ShapeType.getShape("SQUARE").draw();

        /**
         * 方式3：增加枚举
         */
        if(ShapeType.CIRCLE.getName().equalsIgnoreCase(shapeType)){
            return new Circle();
        } else if(ShapeType.RECTANGLE.getName().equalsIgnoreCase(shapeType)){
            return new Rectangle();
        } else if(ShapeType.SQUARE.getName().equalsIgnoreCase(shapeType)){
            return new Square();
        }

        /** 方法4：枚举2方式 */
        ShapeType2.CIRCLE.getShape();
        ShapeType2.RECTANGLE.getShape();
        ShapeType2.SQUARE.getShape();
        return null;
    }
}
