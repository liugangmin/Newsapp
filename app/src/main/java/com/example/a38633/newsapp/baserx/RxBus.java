package com.example.a38633.newsapp.baserx;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

/**
 * Created by 38633 on 2016/10/25.
 */

public class RxBus {
    private static RxBus instance;
    private RxBus(){
    }
    public static RxBus getInstance(){
        if(null == instance) {
            synchronized (RxBus.class) {
                if(null == instance) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }
    private ConcurrentHashMap<Object,List<Subject>> subjectMapper = new ConcurrentHashMap<Object,List<Subject>>();
    public <T>Observable<T> rigester( Object tag){
       List<Subject> subjectList = subjectMapper.get(tag);
       if(null == subjectList) {
           subjectList = new ArrayList<>();
           subjectMapper.put(tag,subjectList);
       }
       Subject<T,T> subject = PublishSubject.create();
       subjectList.add(subject);
        return subject;
    }
    public void unrigester(Object tag){
        List<Subject> subjects = subjectMapper.get(tag);
        if (subjects != null)
        subjectMapper.remove(tag);
    }
    public RxBus unrigester(Object tag,Observable<?> observable){
            List<Subject> subjects = subjectMapper.get(tag);
            if (null != subjects){
                subjects.remove((Subject<?,?>) observable);
                if (subjects.isEmpty()){
                    subjectMapper.remove(tag);
                }
            }
        return getInstance();
    }
    public void post(Object tag, Object context){
        List<Subject> subjects  = subjectMapper.get(tag);
       if (!subjects.isEmpty()){
           for (Subject subject:subjects){
               subject.onNext(context);
           }
       }
    }
}
