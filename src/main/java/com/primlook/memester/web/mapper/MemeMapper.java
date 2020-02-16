package com.primlook.memester.web.mapper;

import com.primlook.memester.domain.Category;
import com.primlook.memester.domain.Language;
import com.primlook.memester.domain.Meme;
import com.primlook.memester.web.model.CategoryDto;
import com.primlook.memester.web.model.LanguageDto;
import com.primlook.memester.web.model.MemeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Created by Bernardo on 1/19/2020
 */
@Mapper(uses = DateMapper.class)
public interface MemeMapper {

    MemeDto memeToMemeDto(Meme meme);

    @Mapping(target = "score", source = "score" , defaultValue = "0")
    @Mapping(target = "likes", source = "likes" , defaultValue = "0")
    @Mapping(target = "dislikes", source = "dislikes" , defaultValue = "0")
    @Mapping(target = "totalVotes", source = "totalVotes" , defaultValue = "0")
    Meme memeDtoToMeme(MemeDto memeDto);

    LanguageDto languageToLanguageDto(Language language);

    Language languageDtoToLanguage(LanguageDto languageDto);

    CategoryDto categoryToCategoryDto(Category category);

    Category categoryDtoToCategory(CategoryDto categoryDto);
}
