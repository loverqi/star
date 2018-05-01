package cn.loverqi.star.core.domain;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cn.loverqi.star.core.annotation.FieldIgnore;
import cn.loverqi.star.core.basepojo.BasePojo;
import cn.loverqi.star.core.basepojo.INode;

/**
 * 菜单权限对象类
 * @author loverqi
 * @date 2018年1月5日
 */
public class StarSysMenu extends BasePojo implements INode<StarSysMenu> {

    private static final long serialVersionUID = 587603712233362065L;

    /** 菜单编号*/
    private String id;

    /** 路径*/
    private String path;

    /** 父目录*/
    private String parent;

    /** 显示内容*/
    private String text;

    /** 图标*/
    private String icon;

    /** 子层目录*/
    @FieldIgnore
    private List<StarSysMenu> children;

    /** 是否启用*/
    private Boolean enable;

    /** 权限英文名*/
    private String funcName;

    /** 是否是末级菜单*/
    private Boolean isLeaf;

    /** 是否启用权限管理*/
    private Boolean isJuris;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent == null ? null : parent.trim();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public List<StarSysMenu> getChildren() {
        return children;
    }

    public void setChildren(List<StarSysMenu> children) {
        this.children = children;
    }

    @JsonIgnore
    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @JsonIgnore
    public Boolean getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Boolean isLeaf) {
        this.isLeaf = isLeaf;
    }

    @JsonIgnore
    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public Boolean getIsJuris() {
        return isJuris;
    }

    public void setIsJuris(Boolean isJuris) {
        this.isJuris = isJuris;
    }

    @Override
    public String getPid() {
        return parent;
    }

    @Override
    public void setPid(String pid) {
        this.parent = pid;
    }
}