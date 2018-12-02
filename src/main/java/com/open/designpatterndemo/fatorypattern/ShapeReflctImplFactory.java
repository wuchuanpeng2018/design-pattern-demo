package com.open.designpatterndemo.fatorypattern;

/**
 * 应用模块名称<p>
 * 通过发射实现工厂模式
 * Copyright: Copyright (C) 2018 XXX, Inc. All rights reserved. <p>
 * Company: 玖富<p>
 *
 * @author wuchp
 * @since 2018/12/2 0:09
 */
public class ShapeReflctImplFactory {

    /**
     * 实现方式1
     * @param clazz
     * @return
     */
    public Object getShapebackObject(Class <? extends Shape> clazz ) {
        Object object = null;
        try {
            object = Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    /**
     *  实现方式2
     * @param clazz
     * @return
     */
    public static Shape getShapeBackShape(Class<? extends Shape> clazz) {
        Shape object = null;

        try {
            object = (Shape) Class.forName(clazz.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return object;
    }

    /**
     * 实现方式3：在jdk9中直接使用泛型的newInstance方法已经过时。重写的getClass()方法如下
     * obj = clazz.getDeclaredConstructor().newInstance();
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T getShapeBackT(Class <? extends T> clazz) {
        T obj = null;

        try {
            obj = (T) Class.forName(clazz.getName()).newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return obj;
    }

}
