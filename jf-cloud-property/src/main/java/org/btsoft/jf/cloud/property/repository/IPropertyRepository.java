package org.btsoft.jf.cloud.property.repository;

import org.btsoft.jf.cloud.property.entity.Property;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropertyRepository extends JpaRepository<Property,Long> {
}
