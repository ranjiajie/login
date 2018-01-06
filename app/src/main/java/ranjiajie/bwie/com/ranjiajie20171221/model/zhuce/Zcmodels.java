package ranjiajie.bwie.com.ranjiajie20171221.model.zhuce;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ranjiajie.bwie.com.ranjiajie20171221.bean.ZcBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.zhuc.Zcpresent;
import ranjiajie.bwie.com.ranjiajie20171221.utils.Api;
import ranjiajie.bwie.com.ranjiajie20171221.utils.RetrofitHelper;
import ranjiajie.bwie.com.ranjiajie20171221.utils.ServiceApi;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Zcmodels implements Zcmodel{

    @Override
    public void getdata(final Zcpresent zcpresent, String mobile, String password) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, Api.HOST)
                .zC(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ZcBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ZcBean zcBean) {
                        zcpresent.showdata(zcBean);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
