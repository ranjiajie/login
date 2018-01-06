package ranjiajie.bwie.com.ranjiajie20171221.present.gouwu;

import android.util.Log;

import java.util.List;

import ranjiajie.bwie.com.ranjiajie20171221.bean.DataBean;
import ranjiajie.bwie.com.ranjiajie20171221.bean.MsgBean;
import ranjiajie.bwie.com.ranjiajie20171221.model.gouwu.Model;
import ranjiajie.bwie.com.ranjiajie20171221.view.IView;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Present implements IPresent{
    Model model;
    IView iView;

    public Present(IView iView) {
        model=new Model();
        this.iView = iView;
    }

    public void detachView() {
        if (iView != null) {
            iView = null;
        }
    }

    @Override
    public void delcont(String uid, String pid) {
        model.delData(this,uid,pid);
    }

    @Override
    public void getcont(String uid) {
        model.getData(this,uid);
    }

    @Override
    public void delData(MsgBean msgBean) {
        iView.delSuccess(msgBean);
    }

    @Override
    public void getData(MsgBean<List<DataBean>> listMsgBean) {
        Log.i("===", "P_getData"+listMsgBean.toString());
        iView.onSuccess(listMsgBean);
    }
}
