package com.lance.demo.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/**
 * Created by immer on 2017/5/14.
 */
public class ObservableDemo {
    public void helloWorldObservable() {
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            for (int i = 0; i < 10000; i++) {
                observableEmitter.onNext(i);
            }
            observableEmitter.onComplete();
        });

        Observer observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("----- subscribe ----");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("----- next value : " + integer + "----");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("------ error ----");
            }

            @Override
            public void onComplete() {
                System.out.println("----- complete ----");
            }
        };

        observable.subscribe(observer);
    }

    public void helloWorldFlowable() {
        Flowable.range(0, 10000).subscribe(new Subscriber<Integer>() {
            Subscription sub;

            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("----- subscribe start ----");
                sub = subscription;
                sub.request(1);
                System.out.println("----- subscribe end ----");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("----- next value : " + integer + "----");
                sub.request(1);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("------ error ----");
            }

            @Override
            public void onComplete() {
                System.out.println("----- complete ----");
            }
        });
    }

    public void helloWorldSingle() {
        Single single = Single.create( singleEmitter -> singleEmitter.onSuccess(1));
        single.subscribe(integer -> {
            System.out.println("------ single value: " + integer + " ----- ");
        });
    }

    public void helloWorldCompletable() {
        Completable completable = Completable.create(CompletableEmitter::onComplete);
        completable.subscribe(() -> System.out.println("------ complete -----"));
    }

}
