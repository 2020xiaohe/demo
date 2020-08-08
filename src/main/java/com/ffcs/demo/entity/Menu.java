package com.ffcs.demo.entity;

public class Menu {
    private Integer menuId;

    private Integer menuParentid;

    private String menuName;

    private String menuUrl;

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuParentid() {
        return menuParentid;
    }

    public void setMenuParentid(Integer menuParentid) {
        this.menuParentid = menuParentid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }
}