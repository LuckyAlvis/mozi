package com.dai.common.utils.gps;

import com.alibaba.fastjson.JSONObject;
import com.dai.common.utils.http.MZHttpUtils;
import com.sun.deploy.net.HttpUtils;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.LinkedList;
import java.util.List;

public class MZGpsUtils {
    public static class GaoDePoi {

        private String status;
        private String info;
        private String infocode;
        private String count;
        private Suggestion suggestion;
        private List<Pois> pois;

        public void setStatus(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getInfo() {
            return info;
        }

        public void setInfocode(String infocode) {
            this.infocode = infocode;
        }

        public String getInfocode() {
            return infocode;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getCount() {
            return count;
        }

        public void setSuggestion(Suggestion suggestion) {
            this.suggestion = suggestion;
        }

        public Suggestion getSuggestion() {
            return suggestion;
        }

        public void setPois(List<Pois> pois) {
            this.pois = pois;
        }

        public List<Pois> getPois() {
            return pois;
        }

        @Override
        public String toString() {
            return "GaoDePoi{" +
                    "status='" + status + '\'' +
                    ", info='" + info + '\'' +
                    ", infocode='" + infocode + '\'' +
                    ", count='" + count + '\'' +
                    ", suggestion=" + suggestion +
                    ", pois=" + pois +
                    '}';
        }
    }
    public static class Pois {

        private String id;
        private List<String> parent;
        private List<String> childtype;
        private String name;
        private String type;
        private String typecode;
        private List<String> biz_type;
        private String address;
        private String location;
        private String tel;
        private String pname;
        private String cityname;
        private String adname;
        private List<String> importance;
        private List<String> shopid;
        private String shopinfo;
        private List<String> poiweight;
        private List<String> distance;
        private List<String> biz_ext;
        private List<String> photos;

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setParent(List<String> parent) {
            this.parent = parent;
        }

        public List<String> getParent() {
            return parent;
        }

        public void setChildtype(List<String> childtype) {
            this.childtype = childtype;
        }

        public List<String> getChildtype() {
            return childtype;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getType() {
            return type;
        }

        public void setTypecode(String typecode) {
            this.typecode = typecode;
        }

        public String getTypecode() {
            return typecode;
        }

        public void setBiz_type(List<String> biz_type) {
            this.biz_type = biz_type;
        }

        public List<String> getBiz_type() {
            return biz_type;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getAddress() {
            return address;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLocation() {
            return location;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getTel() {
            return tel;
        }

        public void setPname(String pname) {
            this.pname = pname;
        }

        public String getPname() {
            return pname;
        }

        public void setCityname(String cityname) {
            this.cityname = cityname;
        }

        public String getCityname() {
            return cityname;
        }

        public void setAdname(String adname) {
            this.adname = adname;
        }

        public String getAdname() {
            return adname;
        }

        public void setImportance(List<String> importance) {
            this.importance = importance;
        }

        public List<String> getImportance() {
            return importance;
        }

        public void setShopid(List<String> shopid) {
            this.shopid = shopid;
        }

        public List<String> getShopid() {
            return shopid;
        }

        public void setShopinfo(String shopinfo) {
            this.shopinfo = shopinfo;
        }

        public String getShopinfo() {
            return shopinfo;
        }

        public void setPoiweight(List<String> poiweight) {
            this.poiweight = poiweight;
        }

        public List<String> getPoiweight() {
            return poiweight;
        }

        public void setDistance(List<String> distance) {
            this.distance = distance;
        }

        public List<String> getDistance() {
            return distance;
        }

        public void setBiz_ext(List<String> biz_ext) {
            this.biz_ext = biz_ext;
        }

        public List<String> getBiz_ext() {
            return biz_ext;
        }

        public void setPhotos(List<String> photos) {
            this.photos = photos;
        }

        public List<String> getPhotos() {
            return photos;
        }

        public double getLongitude() {
            return Double.parseDouble(this.location.split(",")[0]);
        }
        public double getLatitude() {
            return Double.parseDouble(this.location.split(",")[1]);
        }
    }
    public static class Suggestion {

        private List<String> keywords;
        private List<String> cities;
        public void setKeywords(List<String> keywords) {
            this.keywords = keywords;
        }
        public List<String> getKeywords() {
            return keywords;
        }

        public void setCities(List<String> cities) {
            this.cities = cities;
        }
        public List<String> getCities() {
            return cities;
        }

    }

    // 通过高德接口根据关键字、城市获取详细信息

    /**
     * 高德官方API: https://lbs.amap.com/api/webservice/guide/api/search
     *
     * @param keyword 关键字
     * @param city    城市
     * @return 返回值
     */
    public static GaoDePoi getLocationFromGaoDeApiByKeywordAndCity(String keyword, String city) throws Exception {
        List<NameValuePair> params = new LinkedList<>();
        params.add(new BasicNameValuePair("keywords", keyword));
        params.add(new BasicNameValuePair("city", city));
        params.add(new BasicNameValuePair("offset", "1"));
        params.add(new BasicNameValuePair("page", "1"));
        params.add(new BasicNameValuePair("key", "4fbfc2d1afcb4d3408ebfd98847a0e17"));
        params.add(new BasicNameValuePair("extensions", "base"));
        return JSONObject.parseObject(MZHttpUtils.sendGet("https://restapi.amap.com/v3/place/text", params).toString(), GaoDePoi.class);
    }

    /**
     * 两个点之间的距离
     *
     * @param A p1经度
     * @param B p1纬度
     * @param C p2经度
     * @param D p2纬度
     * @return 点之间的距离
     */
    public static double getDistance(double A, double B, double C, double D) {
        double v1 = Math.cos(B * Math.PI / 180) * (C * Math.PI / 180 - A * Math.PI / 180);
        double v2 = D * Math.PI / 180 - B * Math.PI / 180;
        return 6371004 * Math.sqrt(v1 * v1 + v2 * v2);
    }


    public static void main(String[] args) throws Exception {
        GaoDePoi gaoDePoi = getLocationFromGaoDeApiByKeywordAndCity("北京大学", "北京");
        System.out.println(gaoDePoi.toString());
        System.out.println(gaoDePoi.getPois().get(0).getName() + "\t" + gaoDePoi.getPois().get(0).getLongitude() + "\t" + gaoDePoi.getPois().get(0).getLatitude());
    }
}
