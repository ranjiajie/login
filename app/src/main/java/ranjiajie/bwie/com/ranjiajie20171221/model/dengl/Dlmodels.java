package ranjiajie.bwie.com.ranjiajie20171221.model.dengl;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ranjiajie.bwie.com.ranjiajie20171221.bean.DlBean;
import ranjiajie.bwie.com.ranjiajie20171221.present.dengl.Dlpresent;
import ranjiajie.bwie.com.ranjiajie20171221.utils.Api;
import ranjiajie.bwie.com.ranjiajie20171221.utils.RetrofitHelper;
import ranjiajie.bwie.com.ranjiajie20171221.utils.ServiceApi;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Dlmodels implements Dlmodel{
    @Override
    public void getdata(final Dlpresent dlpresent, String mobile, String password) {
        RetrofitHelper.OnCreatApi(ServiceApi.class, Api.HOST)
                .dL(mobile,password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DlBean>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                    }

                    @Override
                    public void onNext(@NonNull DlBean dlBean) {
                        dlpresent.showdata(dlBean);
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
