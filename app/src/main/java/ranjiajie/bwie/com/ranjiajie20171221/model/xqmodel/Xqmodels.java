package ranjiajie.bwie.com.ranjiajie20171221.model.xqmodel;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ranjiajie.bwie.com.ranjiajie20171221.bean.XqBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.xqpresent.Xqpresent;
import ranjiajie.bwie.com.ranjiajie20171221.utils.Api;
import ranjiajie.bwie.com.ranjiajie20171221.utils.RetrofitHelper;
import ranjiajie.bwie.com.ranjiajie20171221.utils.ServiceApi;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Xqmodels implements Xqmodel{
    @Override
    public void getdata(final Xqpresent xqpresent, int pid) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, Api.HOST)
                .xQ("android",pid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<XqBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull XqBean xqBean) {
                        xqpresent.showdata(xqBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("====", "Xqmodels"+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
