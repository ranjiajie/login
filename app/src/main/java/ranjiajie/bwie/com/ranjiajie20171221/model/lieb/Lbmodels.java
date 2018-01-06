package ranjiajie.bwie.com.ranjiajie20171221.model.lieb;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ranjiajie.bwie.com.ranjiajie20171221.bean.LbBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.lieb.Lbpresent;
import ranjiajie.bwie.com.ranjiajie20171221.utils.Api;
import ranjiajie.bwie.com.ranjiajie20171221.utils.RetrofitHelper;
import ranjiajie.bwie.com.ranjiajie20171221.utils.ServiceApi;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Lbmodels implements Lbmodel{
    @Override
    public void getdata(final Lbpresent lbpresent) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, Api.HOST)
                .lieb("android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LbBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull LbBean lbBean) {
                        lbpresent.showdata(lbBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.i("===", "Lbmodels"+e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
