package ranjiajie.bwie.com.ranjiajie20171221.model.gouwu;

import ranjiajie.bwie.com.ranjiajie20171221.present.gouwu.IPresent;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public interface IModel {
    void delData(IPresent iPresent, String uid, String pid);
    void getData(IPresent iPresent, String uid);
}
