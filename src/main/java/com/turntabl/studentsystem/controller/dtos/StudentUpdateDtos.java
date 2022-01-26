package com.turntabl.studentsystem.controller.dtos;

import org.openapitools.jackson.nullable.JsonNullable;

@SuppressWarnings("FieldMayBeFinal")
public class StudentUpdateDtos {
    private JsonNullable<String> name = JsonNullable.undefined();
    private JsonNullable<String> address = JsonNullable.undefined();

    protected StudentUpdateDtos() { }

    public JsonNullable<String> getName() {
        return name;
    }

    public JsonNullable<String> getAddress() {
        return address;
    }

}
