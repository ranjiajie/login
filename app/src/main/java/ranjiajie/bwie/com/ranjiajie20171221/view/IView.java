package ranjiajie.bwie.com.ranjiajie20171221.view;

import java.util.List;

import ranjiajie.bwie.com.ranjiajie20171221.bean.DataBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.MsgBean;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public interface IView {
    void onSuccess(MsgBean<List<DataBean>> listMsgBean);
    void onFailed(Exception e);
    void delSuccess(MsgBean msgBean);
}