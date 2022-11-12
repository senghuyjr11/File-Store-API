package com.example.filestoreapi.payload.page;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * PageReq
 */
@Data
@Builder
@Schema
public class PagesRequest {

    @Schema(defaultValue="0")
    private int page = 0;
    @Schema(defaultValue="10")
    private int offset = 10;
    @Schema(defaultValue="ASC")
    @JsonProperty("sort_direction")
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    @Schema(defaultValue="id")
    @JsonProperty("sort_by")
    private String sortBy = "id";

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Sort.Direction getSortDirection() {
        return this.sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public PagesRequest page(int page) {
        setPage(page);
        return this;
    }

    public PagesRequest offset(int offset) {
        setOffset(offset);
        return this;
    }

    public PagesRequest sortDirection(Sort.Direction sortDirection) {
        setSortDirection(sortDirection);
        return this;
    }

    public PagesRequest sortBy(String sortBy) {
        setSortBy(sortBy);
        return this;
    }


}