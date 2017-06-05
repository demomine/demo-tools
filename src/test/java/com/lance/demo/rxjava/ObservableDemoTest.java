package com.lance.demo.rxjava;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by immer on 2017/5/14.
 */
public class ObservableDemoTest {
    ObservableDemo observableDemo;

    @Before
    public void tearUp() {
        observableDemo = new ObservableDemo();
    }
    @Test
    public void helloWorldObservable() throws Exception {
        observableDemo.helloWorldObservable();
    }

    @Test
    public void helloWorldFlowable() throws Exception {
        observableDemo.helloWorldFlowable();
    }
    @Test
    public void helloWorldSingle() throws Exception {
        observableDemo.helloWorldSingle();
    }

    @Test
    public void helloWorldCompletable() throws Exception {
        observableDemo.helloWorldCompletable();
    }
}