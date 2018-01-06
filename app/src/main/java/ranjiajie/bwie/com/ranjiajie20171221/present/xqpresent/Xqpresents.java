package ranjiajie.bwie.com.ranjiajie20171221.present.xqpresent;

import ranjiajie.bwie.com.ranjiajie20171221.bean.XqBean;
import ranjiajie.bwie.com.ranjiajie20171221.model.xqmodel.Xqmodels;
import ranjiajie.bwie.com.ranjiajie20171221.view.xqview.Xqview;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Xqpresents implements Xqpresent{
    Xqmodels xqmodels;
    Xqview xqview;

    public Xqpresents(Xqview xqview) {
        xqmodels=new Xqmodels();
        this.xqview = xqview;
    }

    @Override
    public void oncont(int pid) {
        xqmodels.getdata(this,pid);
    }

    @Override
    public void showdata(XqBean xqBean) {
        xqview.showdata(xqBean);
    }
}
