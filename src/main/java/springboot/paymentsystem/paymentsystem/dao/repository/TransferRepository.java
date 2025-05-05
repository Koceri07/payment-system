package springboot.paymentsystem.paymentsystem.dao.repository;

import springboot.paymentsystem.paymentsystem.dao.entity.TransferEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransferRepository extends CrudRepository<TransferEntity, Long> {
}
