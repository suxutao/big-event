package org.example;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet(){
        ThreadLocal tl=new ThreadLocal<>();
        new Thread(()->{
            tl.set("hello");
            System.out.println(tl.get()+Thread.currentThread().getName());
            System.out.println(tl.get()+Thread.currentThread().getName());
            System.out.println(tl.get()+Thread.currentThread().getName());
            System.out.println(tl.get()+Thread.currentThread().getName());
        },"first").start();
        new Thread(()->{
            tl.set("world");
            System.out.println(tl.get()+Thread.currentThread().getName());
            System.out.println(tl.get()+Thread.currentThread().getName());
            System.out.println(tl.get()+Thread.currentThread().getName());
            System.out.println(tl.get()+Thread.currentThread().getName());
        },"second").start();
    }
}
