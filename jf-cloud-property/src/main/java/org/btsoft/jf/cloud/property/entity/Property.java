package org.btsoft.jf.cloud.property.entity;

import org.btsoft.jf.cloud.core.entity.BaseEntity;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Table(name = "sys_property_t")
@DynamicInsert
@DynamicUpdate
public class Property extends BaseEntity {

    /**
     * 主键流水号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 字典键值，唯一
     */
    @Column(name = "property_key")
    private String propertyKey;

    /**
     * 字典Value值
     */
    @Column(name = "property_value")
    private String propertyValue;

    /**
     * 字典类型
     */
    @Column(name = "property_type")
    private String propertyType;

    /**
     * 扩展属性1
     */
    private String attr1;

    /**
     * 扩展属性2
     */
    private String attr2;

    /**
     * 扩展属性3
     */
    private String attr3;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPropertyKey() {
        return propertyKey;
    }

    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(String propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getAttr1() {
        return attr1;
    }

    public void setAttr1(String attr1) {
        this.attr1 = attr1;
    }

    public String getAttr2() {
        return attr2;
    }

    public void setAttr2(String attr2) {
        this.attr2 = attr2;
    }

    public String getAttr3() {
        return attr3;
    }

    public void setAttr3(String attr3) {
        this.attr3 = attr3;
    }
}
