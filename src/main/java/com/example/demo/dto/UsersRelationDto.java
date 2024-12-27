package com.example.demo.dto;


import java.util.Date;

public class UsersRelationDto {

    private Long relation_id;

    private int user_id;

    public Long getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(Long relation_id) {
        this.relation_id = relation_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getEntity_id() {
        return entity_id;
    }

    public void setEntity_id(int entity_id) {
        this.entity_id = entity_id;
    }

    public UsersRelationDto(Long relation_id, int user_id, int role_id, int entity_id, Date created_at, Date updated_at) {
        this.relation_id = relation_id;
        this.user_id = user_id;
        this.role_id = role_id;
        this.entity_id = entity_id;
    }

    public UsersRelationDto() {
    }


    private int role_id;

    private int entity_id;






}