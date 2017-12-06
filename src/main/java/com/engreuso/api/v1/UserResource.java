package com.engreuso.api.v1;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Relation(value="user", collectionRelation="users")
public class UserResource extends ResourceSupport {

	private Long userId;
	private String name;
	
}
