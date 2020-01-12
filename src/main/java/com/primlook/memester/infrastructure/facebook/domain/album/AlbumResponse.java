package com.primlook.memester.infrastructure.facebook.domain.album;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlbumResponse {

	private Albums albums;

	private String id;

}
