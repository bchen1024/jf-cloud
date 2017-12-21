package org.btsoft.jf.cloud.property.entity;

import org.btsoft.jf.cloud.core.entity.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name="sys_property_t")
public class Property extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="key")
    private String key;

    @Column(name="value")
    private String value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
