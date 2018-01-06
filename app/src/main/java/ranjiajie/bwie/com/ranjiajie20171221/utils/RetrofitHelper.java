package ranjiajie.bwie.com.ranjiajie20171221.utils;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class RetrofitHelper {
    public static OkHttpClient okHttpClient;
    static
    {
        initOkHttpClient();
    }

    public static OkHttpClient initOkHttpClient()
    {
        if(okHttpClient==null)
        {
            synchronized (RetrofitHelper .class)
            {
                if(okHttpClient==null)
                {
                    okHttpClient=new OkHttpClient();
                }
            }
        }
        return okHttpClient;
    }
    public static<T> T OnCreatApi(Class<T> tClass,String url)
    {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(tClass);
    }
}