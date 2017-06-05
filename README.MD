#   RXJAVA

##  使用场景
>   当你的架构有两个实体类，一个依赖另一个，你想让它们互不影响或者是独立复用它们时。

>   当一个变化的对象通知那些与它自身变化相关联的未知数量的对象时。

>   当一个变化的对象通知那些无需推断具体是谁的对象时。

##  四个角色

1.  Observable
*   和java传统的异步Thread，Future，FutureTask，CompletableFuture相比优点是支持异步调用，复杂情况下更容易处理  
*   Observable的生命周期包含了三种可能的易于与Iterable生命周期事件相比较的事件，下表展示了如何将Observable async/push 与 Iterable sync/pull相关联起来

    |Event| Iterable(pull)| Observable(push)
    |:---:|:---:|:---:|
    |检索数据 |T next() |onNext(T)|
    |发现错误 |throws Exception |onError(Throwable)|
    |完成 |!hasNext() |onCompleted()|  
*   热Observables和冷Observables

    1.  热Observables: 要一创建完就开始发射数据
    2.  冷Observables: 直到有观察者订阅它才开始发射数据，因此这个观察者可以确保会收到整个数据序列
2.  Observer

3.  Subscriber

4.  Subjects

##   操作符
*   io.reactivex.Flowable : 0..N flows, supporting Reactive-Streams and backpressure
*   io.reactivex.Observable: 0..N flows, no backpressure
*   io.reactivex.Single: a flow of exactly 1 item or an error
*   io.reactivex.Completable: a flow without items but only a completion or error signal
*   io.reactivex.Maybe: a flow with no items, exactly one item or an error