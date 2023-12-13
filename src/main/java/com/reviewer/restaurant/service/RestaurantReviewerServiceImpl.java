package com.reviewer.restaurant.service;

import com.reviewer.restaurant.model.dto.RestaurantDto;
import com.reviewer.restaurant.model.entity.RestaurantEntity;
import com.reviewer.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestaurantReviewerServiceImpl implements RestaurantReviewerService{

    private final RestaurantRepository restaurantRepository;

    @Transactional
    @Override
    public void insertRestaurant(RestaurantDto restaurantDto) throws Exception {
        RestaurantEntity restaurantEntity = null;
        try {
            restaurantEntity = restaurantRepository.save(convertRestaurantDtoToRestaurantEntity(restaurantDto));
            if (restaurantEntity.getId() == null) {
                throw new Exception("Insert Restaurant Error");
            }
        } catch (Exception e) {
            log.info("Insert Restaurant Error");
            throw e;
        }
    }

    @Transactional
    @Override
    public void updateRestaurant(RestaurantDto restaurantDto) throws Exception {
        RestaurantEntity restaurantEntity = null;
        try {
            RestaurantEntity existingEntity = restaurantRepository.findRestaurantById(restaurantDto.getRestaurantId());
            if (existingEntity == null ) {
                throw new EntityNotFoundException();
            }
            restaurantEntity = restaurantRepository.save(convertRestaurantDtoToRestaurantEntity(restaurantDto));
            if (restaurantEntity.getId() == null) {
                throw new Exception("Failed to Update Restaurant");
            }
        } catch (Exception e) {
            log.info("Failed to Update Restaurant");
            throw e;
        }
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<RestaurantEntity> restaurantEntities = restaurantRepository.findAll();
        return convertRestaurantEntityListToRestaurantDtoList(restaurantEntities);
    }

    @Override
    public RestaurantDto getRestaurantForUpdateById(Long restaurantId) throws EntityNotFoundException  {
        RestaurantEntity restaurantEntity = null;
        try {
            restaurantEntity = restaurantRepository.findRestaurantById(restaurantId);
            if (restaurantEntity == null) {
                throw new EntityNotFoundException();
            }
        } catch (EntityNotFoundException e) {
            log.info("Failed to Update Restaurant");
            throw e;
        }
        return convertRestaurantEntityToRestaurantDto(restaurantEntity);
    }

    @Transactional
    @Override
    public void deleteRestaurantById(Long restaurantId) throws EntityNotFoundException {
        RestaurantEntity restaurantEntity = null;
        try {
            restaurantEntity = restaurantRepository.findRestaurantById(restaurantId);
            if (restaurantEntity == null) {
                throw new EntityNotFoundException();
            }
            restaurantRepository.deleteById(restaurantId);
        } catch (EntityNotFoundException e) {
            log.info("Failed to Delete Restaurant");
            throw e;
        }
    }

    private RestaurantEntity convertRestaurantDtoToRestaurantEntity(RestaurantDto restaurantDto) {
        return new RestaurantEntity(
                restaurantDto.getRestaurantId(),
                restaurantDto.getRestaurantName(),
                restaurantDto.getFirstDish(),
                new BigDecimal(restaurantDto.getFirstDishPrice()),
                restaurantDto.getSecondDish(),
                new BigDecimal(restaurantDto.getSecondDishPrice()),
                restaurantDto.getThirdDish(),
                new BigDecimal(restaurantDto.getThirdDishPrice()));
    }

    private List<RestaurantDto> convertRestaurantEntityListToRestaurantDtoList(
            List<RestaurantEntity> restaurantEntities) {
        return restaurantEntities
                .stream()
                .map(this::convertRestaurantEntityToRestaurantDto)
                .collect(Collectors.toList());
    }

    private RestaurantDto convertRestaurantEntityToRestaurantDto(RestaurantEntity restaurantEntity) {
        return new RestaurantDto(
                restaurantEntity.getId(),
                restaurantEntity.getRestaurantName(),
                restaurantEntity.getFirstDish(),
                restaurantEntity.getFirstDishPrice().toString(),
                restaurantEntity.getSecondDish(),
                restaurantEntity.getSecondDishPrice().toString(),
                restaurantEntity.getThirdDish(),
                restaurantEntity.getThirdDishPrice().toString());
    }
}
