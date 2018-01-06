package ranjiajie.bwie.com.ranjiajie20171221.present.lieb;

import ranjiajie.bwie.com.ranjiajie20171221.bean.LbBean;
import ranjiajie.bwie.com.ranjiajie20171221.model.lieb.Lbmodels;
import ranjiajie.bwie.com.ranjiajie20171221.view.lieb.Lbview;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Lbpresents implements Lbpresent{
    Lbmodels lbmodels;
    Lbview lbview;

    public Lbpresents(Lbview lbview) {
        lbmodels=new Lbmodels();
        this.lbview = lbview;
    }
    @Override
    public void oncont() {
        lbmodels.getdata(this);
    }

    @Override
    public void showdata(LbBean lbBean) {
        lbview.showdata(lbBean);
    }
}
