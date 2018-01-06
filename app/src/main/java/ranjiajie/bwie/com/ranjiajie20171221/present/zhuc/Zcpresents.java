package ranjiajie.bwie.com.ranjiajie20171221.present.zhuc;

import ranjiajie.bwie.com.ranjiajie20171221.bean.ZcBean;
import ranjiajie.bwie.com.ranjiajie20171221.model.zhuce.Zcmodels;
import ranjiajie.bwie.com.ranjiajie20171221.view.zhuc.Zcview;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Zcpresents implements Zcpresent{
    Zcmodels zcmodels;
    Zcview zcview;

    public Zcpresents(Zcview zcview) {
        zcmodels=new Zcmodels();
        this.zcview = zcview;
    }

    @Override
    public void oncont(String mobile, String password) {
        zcmodels.getdata(this,mobile,password);
    }

    @Override
    public void showdata(ZcBean zcBean) {
        zcview.showmsg(zcBean);
    }
}
