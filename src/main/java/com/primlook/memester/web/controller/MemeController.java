package com.primlook.memester.web.controller;

import com.primlook.memester.security.CurrentUser;
import com.primlook.memester.security.UserPrincipal;
import com.primlook.memester.service.MemeService;
import com.primlook.memester.web.model.MemeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * Created by Bernardo on 1/19/2020
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/meme")
public class MemeController {

    private final MemeService memeService;

    @PostMapping
    public ResponseEntity<MemeDto> createMeme(@RequestBody @Valid MemeDto memeDto,
                                              @CurrentUser UserPrincipal userPrincipal){

        MemeDto savedDto = memeService.saveNewMeme(memeDto, userPrincipal.getUserId());

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedDto.getId())
                .toUri();

        return ResponseEntity.created(location).body(savedDto);
    }
}
