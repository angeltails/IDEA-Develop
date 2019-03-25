package com.jt.common.po;

/**
 * @author FairyTail
 * @date 2019/3/25-11:23
 */
public class Item extends BasePojo {
    private Long id;				//商品id
    private String title;			//商品标题

    //@Column(name="sell_point")	//注定属性和字段一一映射.
    private String sellPoint;		//商品卖点信息
    private Long   price;			//商品价格 Long > dubbo
    private Integer num;			//商品数量
    private String barcode;			//条形码
    private String image;			//商品图片信息   1.jpg,2.jpg,3.jpg
    private Long   cid;				//表示商品的分类id
    private Integer status;			//1正常，2下架

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
