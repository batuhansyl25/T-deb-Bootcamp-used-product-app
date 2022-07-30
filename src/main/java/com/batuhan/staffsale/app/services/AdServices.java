package com.batuhan.staffsale.app.services;


import com.batuhan.staffsale.app.model.dto.AdDTO;
import com.batuhan.staffsale.app.model.entity.Ad;
import com.batuhan.staffsale.app.model.mapper.adMapper;
import com.batuhan.staffsale.app.repository.AdRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdServices {

    private final AdRepository adRepository;

    public Ad create(AdDTO adDTO){
        Ad ad = adMapper.toEntity(adDTO);
        return adRepository.save(ad);
    }

    public List<Ad> getAllProducts(){
        List<Ad> allProducts = adRepository.findAll();
        return allProducts;
    }

    public  Boolean deleteAdById(Long productId){
        try {
            adRepository.deleteById(productId);
        } catch (Exception e){
            return false;
        }
        return  true;
    }

    public Ad update(Long productId, AdDTO adDTO){
        Optional<Ad> adById = adRepository.findById(productId);

        Ad updateAd = adById.get();

        if (!StringUtils.isEmpty(adDTO.getTitle())) {
            updateAd.setTitle(adDTO.getTitle());
        }
        if (!StringUtils.isEmpty(adDTO.getDescription())) {
            updateAd.setDescription(adDTO.getDescription());
        }
        if (!StringUtils.isEmpty(adDTO.getPrice())) {
            updateAd.setPrice(adDTO.getPrice());
        }
        if (!StringUtils.isEmpty(adDTO.getCategory())) {
            updateAd.setCategory(adDTO.getCategory());
        }
        return adRepository.save(updateAd);

    }

}
