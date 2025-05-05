package springboot.paymentsystem.paymentsystem.mapper;

import springboot.paymentsystem.paymentsystem.dao.entity.CardEntity;
import springboot.paymentsystem.paymentsystem.model.request.CreateCardRequest;
import springboot.paymentsystem.paymentsystem.model.response.CardResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.time.LocalDate;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CardMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "expirationDate", source = "createCardRequest", qualifiedByName = "setExpirationDate")
    @Mapping(target = "balance", constant = "0.0")
    @Mapping(target = "cvv", expression = "java(String.valueOf(new java.util.Random().nextInt(1000)))")
    @Mapping(target = "status", constant = "ACTIVE")
    CardEntity toEntity(CreateCardRequest createCardRequest);

    @Named("setExpirationDate")
    default LocalDate setExpirationDate(CreateCardRequest createCardRequest) {
        return LocalDate.now().plusYears(createCardRequest.getExpirationYears());
    }

    CardResponse toResponse(CardEntity cardEntity);
}
