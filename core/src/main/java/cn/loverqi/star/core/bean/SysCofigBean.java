package cn.loverqi.star.core.bean;

import java.io.Serializable;
import java.util.List;

import cn.loverqi.star.core.domain.StarSysConfig;

/**
 * 
 * @author LoverQi
 * @date 2018年11月17日
 */
public class SysCofigBean implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private List<StarSysConfig> list;

    public List<StarSysConfig> getList() {
        return list;
    }

    public void setList(List<StarSysConfig> list) {
        this.list = list;
    }

    public SysCofigBean(List<StarSysConfig> list) {
        super();
        this.list = list;
    }

    public SysCofigBean() {
        super();
    }
}
