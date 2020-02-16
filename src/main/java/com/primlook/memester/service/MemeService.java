package com.primlook.memester.service;

import com.primlook.memester.web.model.MemeDto;

/**
 * Created by Bernardo on 1/19/2020
 */
public interface MemeService {

    MemeDto saveNewMeme(MemeDto memeDto, String userId);
}
