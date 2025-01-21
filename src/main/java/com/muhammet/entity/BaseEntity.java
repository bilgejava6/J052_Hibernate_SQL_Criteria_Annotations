package com.muhammet.entity;

import com.muhammet.entity.enums.State;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class BaseEntity  {
    Long createAt;
    Long updateAt;
    State state;
}
