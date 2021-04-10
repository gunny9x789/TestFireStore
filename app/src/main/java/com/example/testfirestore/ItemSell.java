package com.example.testfirestore;

import java.util.List;

public class ItemSell {
    private int idItemSell, priceDontSale, priceSale, salePercent, totalItem, totalItemSold, itemSoldInMonth, idUserSell;
    private String codeMainCateId, codeSideCateId, nameItemSell, tradeMark, characteristics, eventCode, sale, daySell;
    private List<String> avatarItem;

    public ItemSell(int idItemSell, String codeMainCateId, String codeSideCateId, String nameItemSell, String sale, int salePercent,
                    int priceDontSale, int priceSale, int totalItem, int totalItemSold, int itemSoldInMonth, int idUserSell,
                    String tradeMark, String characteristics, String eventCode, String daySell,
                    List<String> avatarItem) {
        this.idItemSell = idItemSell;
        this.priceDontSale = priceDontSale;
        this.priceSale = priceSale;
        this.salePercent = salePercent;
        this.totalItem = totalItem;
        this.totalItemSold = totalItemSold;
        this.itemSoldInMonth = itemSoldInMonth;
        this.idUserSell = idUserSell;
        this.codeMainCateId = codeMainCateId;
        this.codeSideCateId = codeSideCateId;
        this.nameItemSell = nameItemSell;
        this.tradeMark = tradeMark;
        this.characteristics = characteristics;
        this.eventCode = eventCode;
        this.sale = sale;
        this.daySell = daySell;
        this.avatarItem = avatarItem;
    }

    public ItemSell() {
    }

    ;

    public String getTrademark() {
        return tradeMark;
    }

    public void setTrademark(String trademark) {
        this.tradeMark = trademark;
    }

    public int getIdItemSell() {
        return idItemSell;
    }

    public void setIdItemSell(int idItemSell) {
        this.idItemSell = idItemSell;
    }

    public int getPriceDontSale() {
        return priceDontSale;
    }

    public void setPriceDontSale(int priceDontSale) {
        this.priceDontSale = priceDontSale;
    }

    public int getPriceSale() {
        return priceSale;
    }

    public void setPriceSale(int priceSale) {
        this.priceSale = priceSale;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getTotalItemSold() {
        return totalItemSold;
    }

    public void setTotalItemSold(int totalItemSold) {
        this.totalItemSold = totalItemSold;
    }

    public int getItemSoldInMonth() {
        return itemSoldInMonth;
    }

    public void setItemSoldInMonth(int itemSoldInMonth) {
        this.itemSoldInMonth = itemSoldInMonth;
    }

    public int getIdUserSell() {
        return idUserSell;
    }

    public void setIdUserSell(int idUserSell) {
        this.idUserSell = idUserSell;
    }

    public String getCodeMainCateId() {
        return codeMainCateId;
    }

    public void setCodeMainCateId(String codeMainCateId) {
        codeMainCateId = codeMainCateId;
    }

    public String getCodeSideCateId() {
        return codeSideCateId;
    }

    public void setCodeSideCateId(String codeSideCateId) {
        codeSideCateId = codeSideCateId;
    }

    public String getNameItemSell() {
        return nameItemSell;
    }

    public void setNameItemSell(String nameItemSell) {
        this.nameItemSell = nameItemSell;
    }

    public List<String> getAvatarItemSell() {
        return avatarItem;
    }

    public void setAvatarItemSell(List<String> avatarItemSell) {
        this.avatarItem = avatarItemSell;
    }

    public String getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(String characteristics) {
        this.characteristics = characteristics;
    }

    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        eventCode = eventCode;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getDaySell() {
        return daySell;
    }

    public void setDaySell(String daySell) {
        daySell = daySell;
    }
}
