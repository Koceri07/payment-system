package springboot.paymentsystem.paymentsystem.dao.repository;

import springboot.paymentsystem.paymentsystem.dao.entity.CardEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CardRepository extends CrudRepository<CardEntity, Long> {
    Optional<CardEntity> findByCardNumber(String cardNumber);
}
