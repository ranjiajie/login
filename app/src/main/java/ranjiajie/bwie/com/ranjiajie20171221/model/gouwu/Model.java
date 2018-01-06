package ranjiajie.bwie.com.ranjiajie20171221.model.gouwu;

import android.util.Log;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ranjiajie.bwie.com.ranjiajie20171221.bean.DataBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.MsgBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.gouwu.IPresent;
import ranjiajie.bwie.com.ranjiajie20171221.utils.Api;
import ranjiajie.bwie.com.ranjiajie20171221.utils.RetrofitHelper;
import ranjiajie.bwie.com.ranjiajie20171221.utils.ServiceApi;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Model implements IModel{
    @Override
    public void delData(final IPresent iPresent, String uid, String pid) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, Api.HOST)
                .deleteData(uid,pid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MsgBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgBean msgBean) {
                        iPresent.delData(msgBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("===", "delDataonError"+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void getData(final IPresent iPresent, String uid) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, Api.HOST)
                .getDatas(uid,"android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MsgBean<List<DataBean>>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull MsgBean<List<DataBean>> listMsgBean) {
                        Log.i("===", "getData"+listMsgBean.toString());
                        iPresent.getData(listMsgBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("===", "getDataonError"+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}