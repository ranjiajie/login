package ranjiajie.bwie.com.ranjiajie20171221.utils;

import java.util.List;

import io.reactivex.Observable;
import ranjiajie.bwie.com.ranjiajie20171221.bean.DataBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.DlBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.LbBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.MsgBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.XqBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.ZcBean;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public interface ServiceApi {
    @GET("/user/login")
    Observable<DlBean> dL(@Query("mobile") String mobile,@Query("password") String password  );
    @GET("/user/reg")
    Observable<ZcBean> zC(@Query("mobile") String mobile,@Query("password") String password );
    @GET("/ad/getAd")
    Observable<LbBean> lieb(@Query("source") String source );
    //    http://120.27.23.105/product/getProductDetail?pid=1&source=android
    @GET("/product/getProductDetail")
    Observable<XqBean> xQ(@Query("source") String source, @Query("pid") int pid);
    @GET("product/getCarts")
    Observable<MsgBean<List<DataBean>>> getDatas(@Query("uid") String uid, @Query("source") String source);
    @GET("product/deleteCart")
    Observable<MsgBean> deleteData(@Query("uid") String uid, @Query("pid") String pid, @Query("source") String source);

}
