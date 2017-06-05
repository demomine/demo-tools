package com.lance.demo;

import io.reactivex.Flowable;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Flowable.just("Hello world").subscribe(System.out::println);
    }
}
