package com.batuhan.staffsale.app.model.mapper;

import com.batuhan.staffsale.app.model.dto.AdDTO;
import com.batuhan.staffsale.app.model.dto.userDTO;
import com.batuhan.staffsale.app.model.entity.Ad;
import com.batuhan.staffsale.app.model.entity.User;

public class adMapper {

    public static Ad toEntity(AdDTO adDTO)
    {
        Ad ad = new Ad();
        ad.setTitle(adDTO.getTitle());
        ad.setCategory(adDTO.getCategory());
        ad.setDescription(adDTO.getDescription());
        ad.setPrice(adDTO.getPrice());
        ad.setUserId(adDTO.getUserId());
        return ad;
    }
}
