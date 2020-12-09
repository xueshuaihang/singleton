package com.annotation;

import java.util.Date;

/**
 * @author Shuaihang Xue
 * @date 2020/7/22
 */
public class NoteBook {

    private String name;

    @TransferDate(pattern = "yyyy-MM-dd HH:mm:ss", filedName = "productTime")
    private String productTimeStr;

    private Date productTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductTimeStr() {
        return productTimeStr;
    }

    public void setProductTimeStr(String productTimeStr) {
        this.productTimeStr = productTimeStr;
    }

    public Date getProductTime() {
        return productTime;
    }

    public void setProductTime(Date productTime) {
        this.productTime = productTime;
    }
}
