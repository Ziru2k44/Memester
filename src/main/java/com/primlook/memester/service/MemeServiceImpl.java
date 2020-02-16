package com.primlook.memester.service;

import com.primlook.memester.domain.Category;
import com.primlook.memester.domain.Language;
import com.primlook.memester.domain.Meme;
import com.primlook.memester.domain.Profile;
import com.primlook.memester.exception.CategoryNotFoundException;
import com.primlook.memester.exception.LanguageNotFoundException;
import com.primlook.memester.exception.ProfileNotFoundException;
import com.primlook.memester.repository.CategoryRepository;
import com.primlook.memester.repository.LanguageRepository;
import com.primlook.memester.repository.MemeRepository;
import com.primlook.memester.repository.ProfileRepository;
import com.primlook.memester.web.mapper.MemeMapper;
import com.primlook.memester.web.model.CategoryDto;
import com.primlook.memester.web.model.MemeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Bernardo on 1/19/2020
 */
@RequiredArgsConstructor
@Service
public class MemeServiceImpl implements MemeService {

    private final MemeRepository memeRepository;

    private final LanguageRepository languageRepository;

    private final ProfileRepository profileRepository;

    private final CategoryRepository categoryRepository;

    private final MemeMapper memeMapper;

    @Override
    @Transactional
    public MemeDto saveNewMeme(MemeDto memeDto, String userId) {

        Profile profile = profileRepository.findById(userId)
                .orElseThrow(() -> new ProfileNotFoundException(userId));

        Language language = languageRepository.findById(memeDto.getLanguage().getId())
                .orElseThrow(() -> new LanguageNotFoundException(memeDto.getLanguage().getId().toString()));

        List<Long> categoryIds = memeDto.getCategories().stream().map(CategoryDto::getId).collect(Collectors.toList());

        List<Category> categories = categoryRepository.findAllById(categoryIds);

        if (categoryIds.size() != categories.size())
            throw new CategoryNotFoundException();

        Meme meme = memeMapper.memeDtoToMeme(memeDto);
        meme.setLanguage(language);
        meme.setProfile(profile);
        meme.setCategories(new HashSet<>(categories));

        return memeMapper.memeToMemeDto(memeRepository.save(meme));
    }
}
