package com.example.a38633.newsapp.baserx;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by 38633 on 2016/10/25.
 */

public class RxMannager {
    public RxBus mRxBus = RxBus.getInstance();
    private Map<String, Observable<?>> mObservable = new HashMap<>();
    private CompositeSubscription mCompositeSubscription = new CompositeSubscription();
    public void   on(String eventname, Action1 action1){
        Observable observable = mRxBus.rigester(eventname);
        mObservable.put(eventname,observable);
        mCompositeSubscription.add(observable.observeOn(AndroidSchedulers.mainThread()).subscribe( action1, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                throwable.printStackTrace();
            }
        }));

    }
    public void add(Subscription m){
        mCompositeSubscription.add(m);

    }
    public void clear(){
        mCompositeSubscription.unsubscribe();
        for (Map.Entry<String,Observable<?>> entry: mObservable.entrySet())
        mRxBus.unrigester(entry.getKey(),entry.getValue());

    }
    public void post(Object tag,Object content){
        mRxBus.post(tag,content);

    }

}
