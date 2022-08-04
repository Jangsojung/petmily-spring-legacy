package org.petmily.dao;

import org.petmily.domain.DomainObj;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicDao {

    public DomainObj findByPk(long pk);

    public void insert(DomainObj obj);

    public void update(DomainObj obj);

    public void delete(long pk);
}
