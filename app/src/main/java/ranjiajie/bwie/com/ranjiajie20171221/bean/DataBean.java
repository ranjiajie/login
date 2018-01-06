package ranjiajie.bwie.com.ranjiajie20171221.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class DataBean {

    private String sellerName;
    private String sellerid;
    private List<ListBean> list;
    private boolean checked;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private boolean checked;
        private double bargainPrice;
        private String createtime;
        private String detailUrl;
        private String images;
        private int num;
        private int pid;
        private double price;
        private int pscid;
        private int selected;
        private int sellerid;
        private String subhead;
        private String title;

        public boolean isChecked() {
            return checked;
        }

        public void setChecked(boolean checked) {
            this.checked = checked;
        }

        public double getBargainPrice() {
            return bargainPrice;
        }

        public void setBargainPrice(double bargainPrice) {
            this.bargainPrice = bargainPrice;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public String getDetailUrl() {
            return detailUrl;
        }

        public void setDetailUrl(String detailUrl) {
            this.detailUrl = detailUrl;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getPscid() {
            return pscid;
        }

        public void setPscid(int pscid) {
            this.pscid = pscid;
        }

        public int getSelected() {
            return selected;
        }

        public void setSelected(int selected) {
            this.selected = selected;
        }

        public int getSellerid() {
            return sellerid;
        }
        public void setSellerid(int sellerid) {
            this.sellerid = sellerid;
        }
        public String getSubhead() {
            return subhead;
        }

        public void setSubhead(String subhead) {
            this.subhead = subhead;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
