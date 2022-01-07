package com.example.DCOD3;

public class products {

   private String code;
   private String productname;
   private String quan;
   private String exp;
   private String orig;
   private String prof;

    public products() {
    }

    public products(String code, String productname, String quan, String exp, String orig, String prof) {
        this.code = code;
        this.productname = productname;
        this.quan = quan;
        this.exp = exp;
        this.orig = orig;
        this.prof = prof;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getQuan() {
        return quan;
    }

    public void setQuan(String quan) {
        this.quan = quan;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}

