package cn.loverqi.star.core.basepojo;

import java.util.List;

/**
 * 树形结构对象接口
 * @author loverqi
 * @date 2018年2月6日
 */
public interface INode<T extends INode<T>> {

    /**
     * 获取当前节点的id
     * @return 当前节点的id
     */
    String getOId();

    /**
     * 获取当前节点的父节点id
     * @return 当前节点的父节点id
     */
    String getPid();

    /**
     * 设置当前节点的孩子节点
     * @param children 当前节点的孩子节点
     */
    void setChildren(List<T> children);
}
