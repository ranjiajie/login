package ranjiajie.bwie.com.ranjiajie20171221.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21/021.
 */

public class LbBean {


    private String msg;
    private String code;
    private TuijianBean tuijian;
    private MiaoshaBean miaosha;
    private List<?> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TuijianBean getTuijian() {
        return tuijian;
    }

    public void setTuijian(TuijianBean tuijian) {
        this.tuijian = tuijian;
    }

    public MiaoshaBean getMiaosha() {
        return miaosha;
    }

    public void setMiaosha(MiaoshaBean miaosha) {
        this.miaosha = miaosha;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }

    public static class TuijianBean {

        private String name;
        private List<ListBean> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {

            private int bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private int itemtype;
            private int pid;
            private String price;
            private int pscid;
            private int salenum;
            private int sellerid;
            private String subhead;
            private String title;

            public int getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(int bargainPrice) {
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

            public int getItemtype() {
                return itemtype;
            }

            public void setItemtype(int itemtype) {
                this.itemtype = itemtype;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public int getSalenum() {
                return salenum;
            }

            public void setSalenum(int salenum) {
                this.salenum = salenum;
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

    public static class MiaoshaBean {

        private String name;
        private int time;
        private List<ListBeanX> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public static class ListBeanX {

            private int bargainPrice;
            private String createtime;
            private String detailUrl;
            private String images;
            private int itemtype;
            private int pid;
            private String price;
            private int pscid;
            private int salenum;
            private int sellerid;
            private String subhead;
            private String title;

            public int getBargainPrice() {
                return bargainPrice;
            }

            public void setBargainPrice(int bargainPrice) {
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

            public int getItemtype() {
                return itemtype;
            }

            public void setItemtype(int itemtype) {
                this.itemtype = itemtype;
            }

            public int getPid() {
                return pid;
            }

            public void setPid(int pid) {
                this.pid = pid;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getPscid() {
                return pscid;
            }

            public void setPscid(int pscid) {
                this.pscid = pscid;
            }

            public int getSalenum() {
                return salenum;
            }

            public void setSalenum(int salenum) {
                this.salenum = salenum;
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
}
