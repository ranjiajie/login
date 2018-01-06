package ranjiajie.bwie.com.ranjiajie20171221.present.dengl;

import ranjiajie.bwie.com.ranjiajie20171221.bean.DlBean;
import ranjiajie.bwie.com.ranjiajie20171221.model.dengl.Dlmodels;
import ranjiajie.bwie.com.ranjiajie20171221.view.dengl.Dlview;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class Dlpresents implements Dlpresent{
    Dlmodels dlmodels;
    Dlview dlview;

    public Dlpresents(Dlview dlview) {
        dlmodels=new Dlmodels();
        this.dlview = dlview;
    }

    @Override
    public void oncont(String mobile, String password) {
        dlmodels.getdata(this,mobile,password);
    }

    @Override
    public void showdata(DlBean dlBean) {
        dlview.showdata(dlBean);
    }
}
